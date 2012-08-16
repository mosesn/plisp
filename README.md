#plisp
plisp is pretty lisp.

#Motivation
Lisp is a great language, but it's not that nice looking.  I always find  
when I'm reading it that I wish that the people who had come before me had  
spent some time making it look prettier, without all of the parentheses.

Also, I use a lot of scala, and I am beginning to be able to see the way  
the data will move just by letting my eye drift through the code flow.  
But I thought that I could make it much more clear, by using whitespace like  
python, except instead of designating code blocks with whitespace, I would  
pass arguments with whitespace, which would make them more clearly a tree.  
I realized that structuring my code like a tree was in fact exactly like lisp,  
and that it would be very simple to translate from the language I wanted to  
exist into lisp, which would make my language into a very real and powerful  
language instantly.  I immediately hacked together a prototype.

#Using plisp
The plisp compiler is a script, and can be run from sbt.  Invoke sbt from the  
root directory of plisp, and once you're in the sbt console, call "run  
filename.plisp".  The alternative here is to call 'sbt "run filename.plisp"'  
which has the nice benefit of allowing you to send its output elsewhere,
which is useful because it currently only prints to stdout.
