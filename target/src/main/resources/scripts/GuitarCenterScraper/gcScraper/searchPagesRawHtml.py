from bs4 import BeautifulSoup
#from urllib import request
import requests
from time import sleep
import os, re


class searchPagesRawHtml:
    
    def __init__(self):
        pass

    def calculateHomeURL(self, currentPageNum, instrumentCategory):
	
		#templates: working URLs
		#page 2 examples of each
		
		#Acoustic-Guitars
		#https://www.guitarcenter.com/Acoustic-Guitars.gc?N=18153&Ns=bM&Nao=24&pageName=category-page&recsPerPage=24&profileCountryCode=US&profileCurrencyCode=USD&SPA=true
		
		#7-String--Electric-Guitars
		#https://www.guitarcenter.com/7-String--Electric-Guitars.gc?N=18145+2214&Ns=bM&Nao=24&pageName=category-page&recsPerPage=24&profileCountryCode=US&profileCurrencyCode=USD&SPA=true
		
		#8-String--Electric-Guitars
		#https://www.guitarcenter.com/8-String--Electric-Guitars.gc?N=18145+2213&Ns=bM&Nao=24&pageName=category-page&recsPerPage=24&profileCountryCode=US&profileCurrencyCode=USD&SPA=true

        
        addValue = 24 #24 results per page
        newVal = addValue * (currentPageNum - 1)
		homeURL = ''
        
		if(instrumentCategory == '8-string Electric Guitar'):
			homeURL = f'https://www.guitarcenter.com/8-String--Electric-Guitars.gc?N=18145+2213&Ns=bM&Nao={newVal}&pageName=category-page&recsPerPage=24&profileCountryCode=US&profileCurrencyCode=USD&SPA=true'
			
		elif(instrumentCategory == '7-string Electric Guitar'):
			homeURL = f'https://www.guitarcenter.com/7-String--Electric-Guitars.gc?N=18145+2214&Ns=bM&Nao={newVal}&pageName=category-page&recsPerPage=24&profileCountryCode=US&profileCurrencyCode=USD&SPA=true'
			
		elif(instrumentCategory == 'Acoustic Guitar'):
			homeURL = f'https://www.guitarcenter.com/Acoustic-Guitars.gc?N=18153&Ns=bM&Nao={newVal}&pageName=category-page&recsPerPage=24&profileCountryCode=US&profileCurrencyCode=USD&SPA=true'
			
		else:
			print('Empty/incorrect URL')
		
        return homeURL
    
    
    
    
    def savePage(self, currentPageNum, instrumentCategory):   
             
        # example of URLS:
        # searchUrl2 = 'https://www.guitarcenter.com/8-String--Electric-Guitars.gc?N=18145+2213&Ns=bM&Nao=24&pageName=category-page&recsPerPage=24&profileCountryCode=US&profileCurrencyCode=USD&SPA=true'
        # searchUrl3 = 'https://www.guitarcenter.com/8-String--Electric-Guitars.gc?N=18145+2213&Ns=bM&Nao=48&pageName=category-page&recsPerPage=24&profileCountryCode=US&profileCurrencyCode=USD&SPA=true'
        
		homeURL = ''
		data = ''
		
		#acquire list of proxies
		with open("valid_proxies.txt", "r") as f:
			proxies = f.read().split("\n")
		
		#set URLs for first pages
		if(instrumentCategory == '8-string Electric Guitar'):
			homeURL = 'https://www.guitarcenter.com/8-String--Electric-Guitars.gc'
			
		elif(instrumentCategory == '7-string Electric Guitar'):
			homeURL = 'https://www.guitarcenter.com/7-String--Electric-Guitars.gc'
			
		elif(instrumentCategory == 'Acoustic Guitar'):
			homeURL = 'https://www.guitarcenter.com/Acoustic-Guitars.gc'
			
		else:
			print('Empty/incorrect URL')
				
        #if it's not the first page, recalculate the page URL
        if currentPageNum > 1:
            homeURL = self.calculateHomeURL(self, currentPageNum, instrumentCategory)
            print(homeURL)
			
		#start proxy rotation
        for i, proxy in enumerate(proxies):
			
			pageReadable = False
			
			try:
				print(f"Using the proxy #{i}: {proxies[i]}, URL : {homeURL}") 
				
				#wait 30 seconds in order to avoid detection
				if(i != 0):
					sleep(30)
				
				#read page
				##########readPage = request.urlopen(homeURL)        
				##########statusCode = readPage.getcode()
				
				#request headers
				headers = {'user-agent': 'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/86.0.4240.75 Safari/537.36'}

				#read from site
				res = requests.get(homeURL, headers=headers, proxies={"http": proxies[i]})
				
				#if success, continue
				if(res.status_code == 200):
					pageReadable = True
					data = res.content
					break
			
			except:
				print(f"Proxy failed. Status code: {res.status_code}")				
				
			finally:
				#give up on URL if all proxies are exhausted
				if i == len(proxies):					
					break

		
        #raise exception if all the proxies failed to read the page
        if(pageReadable == False):
            raise Exception('Error: page not found or unable to read page. All proxies failed.')         		
        
        #write to file    
        folder = "./searchpageshtml"    
        currentFile = f"{folder}/{instrumentCategory}/{currentPageNum}.html"
        
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
    def checkPageCount(self, instrumentCategory):
        
        numOfPages = 0
        
        with open("./searchpageshtml/{instrumentCategory}/1.html", 'r', encoding="utf-8") as txt:
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
			print(f'{instrumentCategory} has {numOfPages} pages.')
            
        return numOfPages    
    
