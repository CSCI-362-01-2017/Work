'''
    Team "Work" testing script with HTML output written in Python.
    Team Members: Omer Omer, Joshua Bingham, Eduardo Abreu
    Last Updated: 09/04/2017
'''
import webbrowser
import os

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
        filename = "testView.html"
        file = open(filename, "w")
        file.write(''.join(mylist))
        file.close()

        controller = webbrowser.get()
        controller.open('file://' + os.path.realpath(filename))
        
def main():
	runTest()

main()