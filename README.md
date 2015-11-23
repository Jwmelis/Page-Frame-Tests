# Page-Frame-Tests
Compares number of Page Faults for FIFO and LRU with varying frame amounts

Code by Jonathan Melis
LRUPageFrameTest.java and FIFOPageFrameTest.java


These projects simulate how efficient the Least Recently Used Method and the
First In First Out Method are when dealing with pages and frames. 
They each scan the information in the frames to try to find the corresponding page.
If the search fails, they overwrite one of the frames. 
The Least Recently Used Method overwrites the frame which was accessed the longest 
ago while the First in First out method overwrites the frame which was written the longest ago.
  
In order to test these methods, I have created a random number generator and have each method
run with varying amounts of frame numbers.  By default, test one through nine frames 
as well as the digits zero through eight.  It is possible to change random number sample size
by altering MAX_REQUESTS as well as the range of frame numbers, and random digits, 
but altering MAX and MIN. 
 
The projects, by default, run 10 times per frame amount and average the number of page faults. 
This number may be altered by changing runCount loop.     

To Execute these files, simply open them with your java environment of choice and run
