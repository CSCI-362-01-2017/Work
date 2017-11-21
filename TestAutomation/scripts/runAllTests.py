'''
    Team "Work" testing script with HTML output written in Python.
    Team Members: Omer Omer, Joshua Bingham, Eduardo Abreu
    Last Updated: 09/04/2017
'''
import webbrowser
import os
import platform
import subprocess

def runTest():
        indent = "    "
        mylist = []
        mycss = []

        mycss.append("h1 {\n")
        mycss.append(indent + "margin: 0 auto;\n")
        mycss.append(indent + "text-align: center;\n")
        mycss.append("}\n")
        mycss.append("th {\n")
        mycss.append(indent + "width: 14.29%;\n")
        mycss.append("}\n")
        mycss.append("table {\n")
        mycss.append(indent + "margin: 0 auto;\n")
        mycss.append(indent + "width: 75%;\n")
        mycss.append("}\n")
        mycss.append("table, th, td {\n")
        mycss.append(indent + "border: 1px solid black;\n")
        mycss.append(indent + "border-collapse: collapse;\n")
        mycss.append("}\n")
        
        mylist.append("<head>\n")
        mylist.append(indent + "<title>Test View</title>\n")
        mylist.append(indent + "<link rel=stylesheet href=\"tempStyle.css\"/>\n")
        mylist.append("</head>\n")
        mylist.append("<body>\n")
        mylist.append(indent + "<h1><b>Team \"Work\" Unit Tests</b></h1>\n")
        mylist.append(indent + "<hr>\n")
        mylist.append(indent + "<table>\n")
        mylist.append(indent * 2 + "<tr>\n")
        mylist.append(indent * 3 + "<th>ID</th>\n")
        mylist.append(indent * 3 + "<th>Class</th>\n")
        mylist.append(indent * 3 + "<th>Method</th>\n")
        mylist.append(indent * 3 + "<th>Requirement</th>\n")
        mylist.append(indent * 3 + "<th>Input</th>\n")
        mylist.append(indent * 3 + "<th>Oracle</th>\n")
        mylist.append(indent * 3 + "<th>Status</th>\n")
        mylist.append(indent * 2 + "</tr>\n")
#	    '''
#        1. Populate table with test case information.
#        2. Run drive
#        3. Populate table with return value (sucess or fail)
#        4. run next test
#        '''
        path = os.path.abspath('./../testCases')
        for fileName in os.listdir(path):
            if (fileName != "testCaseTemplate.txt"):
                mylist.append(indent * 2 + "<tr>\n")
                testName = "./../TestCases/" + fileName
                [iD,className,method,requirement,inputs,driverFileName,oracle] = readTest(testName)
                compileDependencies(className)
                compileLine = "javac -cp ./../temp -d ./../temp ./../testCasesExecutables/" + driverFileName + ".java"
                runLine = "java -cp ./../temp " + driverFileName + " " + method + " " + inputs + " " + oracle
                print(fileName)
                print(runLine)
                subprocess.call(compileLine)
                subprocess.call(runLine)
                file = open('./../temp/result.txt','r')
                result = file.readline()
                file.close()
                os.remove('./../temp/result.txt')
                mylist.append(indent * 3 + "<th>" + iD + "</th>\n")
                mylist.append(indent * 3 + "<th>" + className + "</th>\n")
                mylist.append(indent * 3 + "<th>" + method + "</th>\n")
                mylist.append(indent * 3 + "<th>" + requirement + "</th>\n")
                mylist.append(indent * 3 + "<th>" + inputs + "</th>\n")
                mylist.append(indent * 3 + "<th>" + oracle + "</th>\n")
                mylist.append(indent * 3 + "<th>" + result + "</th>\n")
                mylist.append("</tr>\n")

        mylist.append(indent + "</table>\n")
        mylist.append("</body>\n")
	
        makeHTML(mylist)
        makeCSS(mycss)

def makeHTML(mylist):
        new_path = os.path.relpath("..\\temp\\tempView.html")
        
        file = open(new_path, "w")
        file.write(''.join(mylist))
        file.close()

        controller = webbrowser.get()
        controller.open(new_path)
	
def readTest(testName):
    file = open(testName,'r')
    iD = file.readline()[:-1]
    className = file.readline()[:-1]
    method = file.readline()[:-1]
    requirement = file.readline()[:-1]
    inputs = file.readline()[:-1]
    driverFilePath = file.readline()[:-1]
    oracle = file.readline()
    return [iD,className,method,requirement,inputs,driverFilePath,oracle]

def compileDependencies(fileName):
    compileLine = "javac -d ./../temp ./../project/src" + fileName
    subprocess.call(compileLine)
    #os.system(compileLine)

def makeCSS(mycss):
        new_path = os.path.relpath("../temp/tempStyle.css")
        file = open(new_path, "w")
        file.write(''.join(mycss))
        file.close()
        
def main():
    operatingSystem = platform.system()
    if(operatingSystem == "Linux"):
        os.system("rm -r ../temp/*")
    elif(operatingSystem == "Windows"):
        os.system("del /s /q ..\\temp\\*")
        os.system('for /d %x in (..\\temp\\*) do @rd /s /q "%x"')
    elif(operatingSystem == "Darwin"):
        os.system("rm -rf ../temp/*")
    runTest()

main()
