from gcScraper.searchPagesRawHtml import searchPagesRawHtml
from listBuilder.buildList import buildList
from dbLoad.CSV import CSV

class GuitarCenterScraper:

    def __init__(self, name):
        self.name = name
        
    def execute(self):
        print(f'Running Guitar Center search for {self.name}...')
        
        sp = searchPagesRawHtml
        
        #save the first page        
        sp.savePage(sp, 1)
        
        #check how many pages there are
        pageCount = sp.checkPageCount(sp)
        print(f"Pages: {pageCount}")
        
        #save the rest of the pages
        for page in range(pageCount + 1):
        
            if page <= 1:
                continue 
        
            sp.savePage(sp, page)
        
        print(f'{pageCount} html files saved.')
        
        # create list of links for all guitars, from all pages        
        bl = buildList(pageCount)
        pages = bl.getGCFileList()                
        guitarLinks = bl.getGCLinkList(pages, pageCount)
        
        #create CSV file from list of links        
        csv = CSV
        csv.createCSV(csv, guitarLinks) 
        print("Guitar list saved successfully.")       
        
        
        
#run program    
x = GuitarCenterScraper('8-string')
x.execute()