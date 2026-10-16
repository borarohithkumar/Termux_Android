-- 1. General Options
vim.g.mapleader = " "
local opt = vim.opt
opt.number = true
opt.relativenumber = true
opt.mouse = "a"
opt.shiftwidth = 4
opt.tabstop = 4
opt.termguicolors = true
opt.clipboard = "" -- Handled by custom OSC 52 logic
opt.runtimepath:prepend(vim.fn.stdpath("data") .. "/site")
opt.signcolumn = "yes"

vim.g.loaded_node_provider = 0
vim.g.loaded_python3_provider = 0
vim.g.loaded_perl_provider = 0
vim.g.loaded_ruby_provider = 0

-- Transparent Background
vim.api.nvim_set_hl(0, "Normal", { bg = "none" })
vim.api.nvim_set_hl(0, "NormalFloat", { bg = "none" })

-- 2. Bootstrap lazy.nvim
local lazypath = vim.fn.stdpath("data") .. "/lazy/lazy.nvim"
if not vim.loop.fs_stat(lazypath) then
  vim.fn.system({
    "git",
    "clone",
    "--filter=blob:none",
    "https://github.com",
    "--branch=stable",
    lazypath,
  })
end
vim.opt.rtp:prepend(lazypath)

-- 3. Unified Plugin Setup
require("lazy").setup({
  -- UI & Theme
  { "catppuccin/nvim", name = "catppuccin", priority = 1000, config = function() vim.cmd.colorscheme "catppuccin" end },
  { "nvim-lualine/lualine.nvim", dependencies = { "nvim-tree/nvim-web-devicons" }, config = function() require("lualine").setup() end },
  { "nvim-tree/nvim-tree.lua", config = function() require("nvim-tree").setup() end },
  { "nvim-telescope/telescope.nvim", tag = "0.1.5", dependencies = { "nvim-lua/plenary.nvim" } },

  -- Treesitter
  {
    "nvim-treesitter/nvim-treesitter",
    branch = "main",
    lazy = false,
    build = ":TSUpdate",
    config = function()
      require("nvim-treesitter").install({
        "lua",
        "vim",
        "javascript",
        "typescript",
        "jsx",
        "tsx",
        "html",
        "css",
        "python",
        "markdown",
        "java",
		"sql",
      })

      vim.api.nvim_create_autocmd("FileType", {
        pattern = "*",
        callback = function(args)
          pcall(vim.treesitter.start, args.buf)
        end,
      })
    end,
  },

  -- Native LSP Config (Modern Neovim 0.11+ API)
  {
    "neovim/nvim-lspconfig",
    dependencies = {
      "williamboman/mason.nvim",
      "williamboman/mason-lspconfig.nvim",
      "hrsh7th/cmp-nvim-lsp",
    },
    config = function()
      require("mason").setup()
      require("mason-lspconfig").setup({
        ensure_installed = { "pyright", "ts_ls", "html", "cssls", "jdtls", "sqls" },
        automatic_enable = false,
      })

      local capabilities = require("cmp_nvim_lsp").default_capabilities()

      -- Standard Web & Python Servers + SQL
      local servers = { "pyright", "ts_ls", "html", "cssls", "sqls" }
      for _, server in ipairs(servers) do
        vim.lsp.config[server] = {
          capabilities = capabilities,
        }
      end

      -- lua_ls: uses native root_markers; safe fallback avoids scanning $HOME
      vim.lsp.config.lua_ls = {
        capabilities = capabilities,
        root_dir = function(bufnr)
          local fname = vim.api.nvim_buf_get_name(bufnr)
          local root = vim.fs.root(fname, { ".luarc.json", ".luarc.jsonc", ".git" })
          if not root or root == vim.env.HOME then
            return vim.fs.dirname(fname)
          end
          return root
        end,
        single_file_support = true,
        settings = {
          Lua = {
            runtime = { version = "LuaJIT" },
            workspace = {
              checkThirdParty = false,
              library = {
                vim.env.VIMRUNTIME,
                vim.fn.stdpath("config"),
              },
            },
            telemetry = { enable = false },
          },
        },
      }

      -- Java Language Server
      vim.lsp.config.jdtls = {
        cmd = { "jdtls" },
        capabilities = capabilities,
        root_markers = { "pom.xml", "build.gradle", ".git" },
        single_file_support = true,
      }

      -- Enable all servers including sqls
      vim.lsp.enable({ "pyright", "ts_ls", "html", "cssls", "lua_ls", "jdtls", "sqls" })
    end,
  },

  -- Formatting Engine
  {
    "stevearc/conform.nvim",
    event = { "BufReadPre", "BufNewFile" },
    config = function()
      require("conform").setup({
        formatters_by_ft = {
          lua = { "stylua" },
		  sql = { "sql_formatter" },
          python = { "isort", "black" },
          javascript = { "prettier" },
          typescript = { "prettier" },
          javascriptreact = { "prettier" },
          typescriptreact = { "prettier" },
          css = { "prettier" },
          html = { "prettier" },
          json = { "prettier" },
          java = { "google-java-format" },
        },
      })
    end,
  },

  -- Copilot Core (Configured for Ghost Text + Alt bindings)
  --  {
  --    "zbirenbaum/copilot.lua",
  --    cmd = "Copilot",
  --    event = "InsertEnter",
  --    pin = true,
  --    config = function()
  --      require("copilot").setup({
  --        copilot_node_command = "node",
  --        suggestion = { 
  --          enabled = true,
  --          auto_trigger = true,
  --          keymap = {
  --            accept = "<Tab>",           -- Tab accepts full suggestion
  --            accept_line = "<M-l>",      -- Alt + l accepts line-by-line
  --            accept_word = "<M-w>",      -- Alt + w accepts word-by-word
  --            next = "<M-]>",             
  --            prev = "<M-[>",             
  --            dismiss = "<C-]>",
  --          },
  --        },
  --        panel = { enabled = false },
  --      })
  --    end,
  --  },

  -- Supermaven AI (Configured exactly like Copilot)
  {
    "supermaven-inc/supermaven-nvim",
    event = "InsertEnter",
	pin = true,
    config = function()
      require("supermaven-nvim").setup({
        keymaps = {
          accept_suggestion = "<Tab>",      -- Tab accepts full suggestion
          clear_suggestion = "<C-]>",       -- Dismiss
          accept_word = "<M-w>",            -- Alt + w accepts word-by-word
        },
        ignore_filetypes = {},
        color = {
          suggestion_color = "#888888",
          cterm = 244,
        },
        disable_inline_completion = false,
      })

      -- Custom line-by-line accept (<M-l>) to match Copilot
      vim.keymap.set("i", "<M-l>", function()
        local suggestion = require("supermaven-nvim.completion_preview").suggestion
        if suggestion and suggestion ~= "" then
          local line = suggestion:match("^[^\r\n]*[\r\n]?")
          if line and #line > 0 then
            vim.api.nvim_feedkeys(line, "n", false)
            require("supermaven-nvim.binary.binary_handler"):on_update()
          end
        end
      end, { desc = "Supermaven accept line" })
    end,
  },

  -- Autocompletion
  {
    "hrsh7th/nvim-cmp",
    dependencies = {
      "L3MON4D3/LuaSnip",
      build = (function()
        if vim.uv.os_uname().sysname:find("Windows") then return nil end
        return "make install_jsregexp"
      end)(),
      dependencies = { "saadparwaiz1/cmp_luasnip", "onsails/lspkind.nvim" },
    },
    config = function()
      local cmp = require("cmp")
      local lspkind = require("lspkind")

      lspkind.init()

      cmp.setup({
        snippet = {
          expand = function(args)
            require("luasnip").lsp_expand(args.body)
          end,
        },
        formatting = {
          format = lspkind.cmp_format({
            mode = "symbol_text",
            maxwidth = 50,
            ellipsis_char = "...",
            menu = { nvim_lsp = "[LSP]", luasnip = "[Snip]", buffer = "[Buf]" },
          }),
        },
        mapping = cmp.mapping.preset.insert({
          ["<C-Space>"] = cmp.mapping.complete(),
          ["<CR>"] = cmp.mapping.confirm({ select = true }),
        }),
        sources = cmp.config.sources({
          { name = "nvim_lsp", group_index = 1 },
          { name = "luasnip", group_index = 1 },
        }, {
          { name = "buffer", group_index = 2 },
        }),
      })
    end,
  },
}, { rocks = { enabled = false } })

-- 4. Keybindings
local key = vim.keymap.set
key("n", "<leader>e", ":NvimTreeToggle<CR>", { silent = true })
local builtin = require("telescope.builtin")
key("n", "<leader>ff", builtin.find_files, {})
key("n", "<leader>fg", builtin.live_grep, {})

-- Formatting Keybind
key({ "n", "v" }, "<leader>f", function()
  require("conform").format({ lsp_fallback = true, async = false, timeout_ms = 1000 })
end, { desc = "Format file or range" })

-- LSP Keymaps
key("n", "<leader>rn", vim.lsp.buf.rename, { desc = "Rename variable" })
key("n", "]d", function() vim.diagnostic.jump({ count = 1, float = true }) end, { desc = "Next Diagnostic" })
key("n", "[d", function() vim.diagnostic.jump({ count = -1, float = true }) end, { desc = "Prev Diagnostic" })
key("n", "gd", vim.lsp.buf.definition, {})
key("n", "K", vim.lsp.buf.hover, {})

-- 5. Native OSC 52 Clipboard
vim.api.nvim_create_autocmd("TextYankPost", {
  callback = function()
    if vim.v.event.regname == "" or vim.v.event.regname == "+" then
      local client = require("vim.ui.clipboard.osc52")
      client.copy("+")(vim.v.event.regcontents)
    end
  end,
})

key("n", "<leader>p", '"+p', { desc = "Paste from System" })
