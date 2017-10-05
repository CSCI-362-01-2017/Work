'''
    Team "Work" testing script with HTML output written in Python.
    Team Members: Omer Omer, Joshua Bingham, Eduardo Abreu
    Last Updated: 09/04/2017
'''

def runTest():
        indent = "    "
        mylist = []
        
        mylist.append("<head>\n")
        mylist.append(indent + "<title>Test View</title>\n")
        mylist.append(indent + "<link rel=stylesheet href=\"style.css\"/>\n")
        mylist.append("</head>\n")
        mylist.append("<body>\n")
        mylist.append(indent + "<h1><b>Team \"Work\" Unit Tests</b></h1>\n")
        mylist.append(indent + "<hr>\n")
        mylist.append(indent + "<table>\n")
        mylist.append(indent * 2 + "<tr>\n")
        mylist.append(indent * 3 + "<th>ID</th>\n")
        mylist.append(indent * 3 + "<th>Class</th>\n")
        mylist.append(indent * 3 + "<th>Method</th>\n")
        mylist.append(indent * 3 + "<th>Input</th>\n")
        mylist.append(indent * 3 + "<th>Oracle</th>\n")
        mylist.append(indent * 3 + "<th>Outcome</th>\n")
        mylist.append(indent * 3 + "<th>Status</th>\n")
        mylist.append(indent * 2 + "</tr>\n")
        mylist.append(indent + "</table>\n")
        mylist.append("</body>\n")
        
        makeHTML(mylist)

def makeHTML(mylist):
	file = open("testView.html", "w")
	file.write(''.join(mylist))
	file.close()
        
def main():
	runTest()

main()
