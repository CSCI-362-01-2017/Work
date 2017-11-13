'''
    Team "Work" testing script with HTML output written in Python.
    Team Members: Omer Omer, Joshua Bingham, Eduardo Abreu
    Last Updated: 09/04/2017
'''
import webbrowser
import os
import platform
import shutil

def runTest(numTests):
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
#        mylist.append(indent * 3 + "<th>Outcome</th>\n")
        mylist.append(indent * 3 + "<th>Status</th>\n")
        mylist.append(indent * 2 + "</tr>\n")
#	    '''
#        1. Populate table with test case information.
#        2. Run drive
#        3. Populate table with return value (sucess or fail)
#        4. run next test
#        '''
        for i in range(numTests):
            mylist.append(indent * 2 + "<tr>\n")
            testName = "./../TestCases/testCase" + str(i) + '.txt'
            [iD,className,method,requirement,inputs,driverFileName,oracle] = readTest(testName)
            compileDependencies(className)
            compileLine = "javac -cp ./../temp -d ./../temp ./../testCasesExecutables/" + driverFileName + ".java"
            runLine = "java -cp ./../temp " + driverFileName + " " + method + " " + inputs + " " + oracle
            print(runLine)
            os.system(compileLine)
            os.system(runLine)
            file = open('./../temp/result.txt','r')
            result = file.readline()
            file.close()
            os.remove('./../temp/result.txt')
            mylist.append(indent * 3 + "<th>" + iD + "</th>\n")
            mylist.append(indent * 3 + "<th>" + className + "</th>\n")
            mylist.append(indent * 3 + "<th>" + method + "</th>\n")
            mylist.append(indent * 3 + "<th>" + inputs + "</th>\n")
            mylist.append(indent * 3 + "<th>" + oracle + "</th>\n")
            mylist.append(indent * 3 + "<th>" + result + "</th>\n")
            mylist.append("</tr>\n")

        mylist.append(indent + "</table>\n")
        mylist.append("</body>\n")
	
        makeHTML(mylist)

def makeHTML(mylist):
        filename = "../temp/testView.html"
        file = open(filename, "w")
        file.write(''.join(mylist))
        file.close()

        controller = webbrowser.get()
        controller.open('file://' + os.path.realpath(filename))
	
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
    os.system(compileLine)
        
def main(numTests):
    operatingSystem = platform.system()
    if(operatingSystem == "Linux"):
        os.system("rm -r ../temp")
    elif(operatingSystem == "Windows"):
        os.system("del /s /q ..\\temp\\*")
        os.system('for /d %x in (..\\temp\\*) do @rd /s /q "%x"')
    elif(operatingSystem == "Darwin"):
        os.system("rm -rf ../temp")
    runTest(numTests)

main(5)
