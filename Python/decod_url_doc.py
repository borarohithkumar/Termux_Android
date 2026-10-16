import requests
from bs4 import BeautifulSoup

def decode_doc_secret(url):
    resp = requests.get(url)
    resp.raise_for_status()
    html = resp.text
    soup = BeautifulSoup(html, "html.parser")
    table = soup.find("table")
    
    if table is None:
        raise ValueError("No Table found in the Document Source")
    
    rows = table.find_all("tr")
    grid = {}
    max_x, max_y = 0, 0
    
    for row in rows:
        cells = row.find_all("td")
        
        if len(cells) != 3:
            continue
        
        try:
            x = int(cells[0].get_text(strip=True))
            ch = cells[1].get_text()
            y = int(cells[2].get_text(strip=True))
        except ValueError:
            continue
        
        grid[(x, y)] = ch
        if x > max_x:
            max_x = x
        if y > max_y:
            max_y = y
    
    for y in range(max_y, -1, -1):
        for x in range(max_x + 1):
            print(grid.get((x, y), " "), end = "")
        print()

decode_doc_secret("https://docs.google.com/document/d/e/2PACX-1vSvM5gDlNvt7npYHhp_XfsJvuntUhq184By5xO_pA4b_gCWeXb6dM6ZxwN8rE6S4ghUsCj2VKR21oEP/pub")
