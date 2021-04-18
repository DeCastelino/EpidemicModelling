import sys
import time
import os

CMD = "java -cp bin:bin/jopt-simple-5.0.2.jar RmitCovidModelling"

testfile = open (sys.argv [1], "r")
outfile = open (sys.argv [2], "w")

graphs = []
testCases = []
implementations = ["adjlist", "adjmat", "incmat"]

line = testfile.readline ()
while (line != "\n"):
    graphs.append (line)
    line = testfile.readline ()

line = testfile.readline ()
while (line != ""):
    testCases.append (line)
    line = testfile.readline ()

testfile.close ()

for impl in implementations:
    for graph in graphs:
        for test in testCases:
            totalTime = 0
            for i in range (3):
                cmd = CMD + " -f graphs/" + graph.strip () + str (i + 1) + ".net " + impl + "<testCases/" + test.strip ()
                startTime = time.time ()
                os.system (cmd)
                finishTime = time.time ()
                totalTime += finishTime - startTime
            avgTime = totalTime / 3
            outfile.write (impl + "," + graph.strip () + "," + test.strip () + "," + str(avgTime) + "\n")

outfile.close ()
