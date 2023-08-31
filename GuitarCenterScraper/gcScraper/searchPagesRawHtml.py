from bs4 import BeautifulSoup
from urllib import request
import os, re


class searchPagesRawHtml:
    
    def __init__(self):
        pass

    def calculateHomeURL(self, currentPageNum):
        
        addValue = 24 #24 results per page
        newVal = addValue * (currentPageNum - 1)
        
        URL = f'https://www.guitarcenter.com/8-String--Electric-Guitars.gc?N=18145+2213&Ns=bM&Nao={newVal}&pageName=category-page&recsPerPage=24&profileCountryCode=US&profileCurrencyCode=USD&SPA=true'
    
        return URL
    
    
    
    
    def savePage(self, currentPageNum):   
             
        # example of URLS:
        # searchUrl2 = 'https://www.guitarcenter.com/8-String--Electric-Guitars.gc?N=18145+2213&Ns=bM&Nao=24&pageName=category-page&recsPerPage=24&profileCountryCode=US&profileCurrencyCode=USD&SPA=true'
        # searchUrl3 = 'https://www.guitarcenter.com/8-String--Electric-Guitars.gc?N=18145+2213&Ns=bM&Nao=48&pageName=category-page&recsPerPage=24&profileCountryCode=US&profileCurrencyCode=USD&SPA=true'
        homeURL = 'https://www.guitarcenter.com/8-String--Electric-Guitars.gc'
        
        #if it's not the first page, recalculate the page URL
        if currentPageNum > 1:
            homeURL = self.calculateHomeURL(self, currentPageNum)
            print(homeURL)
        
        
        readPage = request.urlopen(homeURL)        
        statusCode = readPage.getcode()
        
        if(statusCode != 200):
            raise Exception('Error: page not found or unable to read page.') 
        
        else:
            print("reading page...")
        
        data = readPage.read()
        
        #write to file    
        folder = "./searchpageshtml"    
        currentFile = f"{folder}/{currentPageNum}.html"
        
        try:
            if(currentPageNum == 1):
                if not os.path.exists(folder):
                    os.mkdir(folder)
            
            file = open(currentFile, 'wb')
            file.write(data)
            print(f'Page {currentPageNum} saved.')
            file.close()
        
        except:
            raise Exception('Error writing to html file.')
    
    
    
    
    #check if next page is available
    def checkPageCount(self):
        
        numOfPages = 0
        
        with open("./searchpageshtml/1.html", 'r', encoding="utf-8") as txt:
            soup = BeautifulSoup(txt, "html.parser")
                        
            rel_soup = soup.find_all('a', attrs={'rel': 'nofollow'})        
            num_rel = len(rel_soup)
            num_arr = []                
            
            #for i in rel_soup:
            for x in range(num_rel):
                num_content = rel_soup[x].text.strip()
                
                if num_content.isnumeric():
                    num_arr.append(num_content)                                
                            
                
            numOfPages = len(num_arr)
            
        return numOfPages    
    
