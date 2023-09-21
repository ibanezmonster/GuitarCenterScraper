from gcScraper.searchPagesRawHtml import searchPagesRawHtml
from listBuilder.buildList import buildList
from dbLoad.JSON import JSON

class GuitarCenterScraper:

    def __init__(self, name):
        self.name = name



    def execute(self):
        instrumentCategory = self.name

        print(f'Running Guitar Center search for {instrumentCategory}...')

        sp = searchPagesRawHtml

        #save the first page        
        sp.savePage(sp, 1, instrumentCategory)

        #check how many pages there are by reading the links on the first  page
        pageCount = sp.checkPageCount(sp, instrumentCategory)
        print(f"Total page count: {pageCount}")

        #save the rest of the pages
        for page in range(pageCount + 1):

            if page <= 1:
                continue 

            sp.savePage(sp, page, instrumentCategory)

        print(f'{pageCount} html files saved.')

        # create list of links for all guitars, from all pages        
        bl = buildList(pageCount)
        pages = bl.getGCFileList(instrumentCategory)                
        guitarLinks = bl.getGCLinkList(pages, pageCount)

        #create JSON file from list of links        
        json = JSON
        json.createJSON(json, guitarLinks, instrumentCategory) 
        print("Guitar list saved successfully.")       
        
        
        
#run program
#instrumentCategory is received from java, decides which search to run

#Categories:
# 'Acoustic Guitar'
# '8-string Electric Guitar'
# '7-string Electric Guitar'

instrumentCategory = ''
print(f'Python: search for:  {instrumentCategory}')
x = GuitarCenterScraper(instrumentCategory)
x.execute()