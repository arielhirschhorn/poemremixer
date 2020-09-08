# poemremixer
Implementing a hashtable to remix a poem of your choice!

## My Inspiration
I was inspired to make this simple program after reading about [code poems](http://code-poetry.com/)! I have always admired the similarities between code and poetry- line breaks, writing things as efficiently and elegantly as possible. When I wrote this script, I was taking a data structures class and was interested in how the hashing function stored data. I noticed that the pattern would be great for remixing poetry. If you are looking for a way to shuffle your poem, try using a hash table!

## How to use it
Simply change the program's arguments to your poem as a .txt file and the size of the hash table (an integer) you'd like to create. I would make the size of the hash table about half of the number of lines in your poem for the best results. Each line should be separated by a newline. If you separate your poem stanzas, the remixer will create new stanzas for you! I've included the Red Wheelbarrow by William Carlos Williams (testPoem.txt) as a test input. Feel free to try it out!

### Sample I/O 
#### This is what your terminal should look like: 
javac Hash.java
java Hash yourPoemHere.txt 4




