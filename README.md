# ClockPuzzleSolver

This is my attempt to create a solver for [this puzzle](https://youtu.be/29wQvtMDnyo) from Final Fantasy XIII-2.

Something not explained in the rules in that link: You can have up to 13 numbers on the clock, and the numbers (which can go up to six) are randomized.

If there weren't a time limit, I'd probably solve them myself manually, but since there is a time limit, I pretty much just use [this website](http://shauninman.com/utils/ffxiii2/) every time I play the game.

The solver on the website does everything I need it to, I just want to see if I can recreate it.

Please note that this project is currently incomplete, and it is only public for the purpose of letting friends/potential employers see what I work on. If you attempt to use or fork this and have issues, I cannot help you.

---

# Current Progress

The pure Java part works perfectly and solves the problem just fine.

Unfortunately, I rather belatedly realized that this type of project isn't even one that needs to interact with a server, and it would be much more appropriate to solve the problem with JavaScript, rather than sending information to the server.

Additionally, I got in a bit over my head with the non-Java portion, and I need to first work on a simpler project to learn how to deal with jQuery, sending information to/from the server, etc., if I wish to complete this as I originally intended.
