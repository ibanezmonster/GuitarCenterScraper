from bs4 import BeautifulSoup
#from run.gc_run import instrumentCategory

class buildList:
    
    numOfPages = 0
    
    
    
    def __init__(self, numOfPages):
        self.numOfPages = numOfPages
    
    
    
    def getGCFileList(self, instrumentCategory):
        
        baseURL = 'searchpageshtml'            
        fileURLs = []
            
        for i in range(self.numOfPages + 1):
            
            if i < 1:
                continue
            
            currentFile = f'{baseURL}/{instrumentCategory}/{i}.html'            
            fileURLs.append(currentFile)                
        
        return fileURLs
    
               
    def getGCLinkList(self, pages, pageCount):
        
        #dictionary for guitar listing and URLs
        guitarURLs = {}
        pageHTMLList = []
        models = []
        links = []
        
        for i in range(pageCount):
                        
            currentPage = pages[i]            
        
            #one page at a time
            with open(currentPage, 'r', encoding='utf-8') as f:
                soup = BeautifulSoup(f, 'html.parser')                        
                pageHTMLList = soup.find_all('a', attrs={'class': 'jsx-2420341498 product-name gc-font-light font-normal text-base leading-[18px] md:leading-6 text-[#2d2d2d] mb-2 md:h-[72px] h-[36px] hover:underline'})
                        
            #populate models list
            for i in range(len(pageHTMLList)):                                        
                models.append(pageHTMLList[i].text.strip())                                                
            
            #populate links list
            for text in pageHTMLList:
                links.append(text['href'])
             
        #populate guitarURLs with models as keys and links as values   
        guitarURLs = dict(zip(models, links))
       
        return guitarURLs