from datetime import date
import os
import json

class CSV:
       
    def __init__(self):
        self.guitarLinks = self
    
    
    
    def createCSV(self, guitarLinks):
        dt = date.today()        
        folder = "./list"      
        filePath = f"{folder}/list-{dt}.json"
                
        if not os.path.exists(folder):
            os.mkdir(folder)
        
        fields = ["Models", "Links"]
                
        with open(filePath, "w") as f:
            json.dump(guitarLinks, f)
        
        
        
        