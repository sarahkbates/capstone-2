<h1>The Problem Solving Framework : 'UPER'</h1>

* U = "Understand"
* P = "Plan"
* E = "Execute"
* R = "Reflect" / "Refactor"

<h2>1. Understanding the Problem</h2>
* I want to make a game. And I want to make Flappy Bird, because I really like Flappy Bird.

* I need to use a JFrame and have a JPanel so that there's a UI

* I can use an ArrayList to make the pipes

* I will need to add a countdown with an array to be able to implement a lambda function and a stream

* Score will be kept, 1 point for passing each set of pipes...not sure how to display high score...might not do that

* The bird should fall if you hit a pipe and then Game Over

* The bird should not be able to go through pipes
*
<h2>
    2. Planning the Solution
</h2>
* Interfaces will be JFrame, MouseListener, and KeyListener

* Not entirely sure how to add in an Abstract class...more to come on that.

* Pipes...use ArrayList to create infinate pipes being created as the game continues

* Use x and y cordinates and YMotion to control bird, and set where pipes should go

* Mouse Listener will start game and allow to play by clicking mouse. Key Listener will allow you to play with the spacebar...hard to play with mouse if you have a trackpad

* When Game Over occurs, you can restart the game by clicking the mouse again

*
*
<h2>
    3. Executing the Plan
</h2>
* Things went basically all according to plan. I had a boolean issue where unless I declared the boolean "started" to true, the game would not run. I fixed this by rearranging the order of my methods...no real strategy to this, just a lot of copying and pasting until it worked. And then I simply declared the boolean "started" in the beginning, and then in my MouseClicked method set "started" to true. This way if you don't click, the screen says "Click to Start!"


* I wasn't sure how to implement a lambda funciton and a stream, per the requirements, because I do not have any arrays in my code. Amir gave me the idea that if I created a countdown at the beginning, so when you click to start it counts down 3, 2, 1, that I could make that an array, and then use a lambda function and a stream. This was difficult, because I honestly wasn't sure how to do it. But, I figured it out! 

* I also ran into the issue of using an Abstract class, because it simpy was not necessary. I decided that for my code, in order to have true clean code, an Abstract class was not necessary. So, while I don't have this specific requirement, I feel like having clean and logical code took priority over adding something that truly was not needed.
*
*
*
*
*
<h2>
    4. Reflection / Refactor
</h2>
* If I had more time, I would make a high score feature. So, when the game started, you could click a button and view the high scores. And after you played, if you acheived a high score (like top 5), then it would ask you to enter your name, so it would be like an arcade game and have a leaderborad. This would require having a buttton Panel and using a lot of concepts from model-view-controller, which I simply did not have time for.

* I also was wondering if maybe having separate classes for Bird and Pipes would make my code "claner", but from my understanding, too many classes makes things messy. And they are really just objects, not actual classes.

* I would like to make another game, and then have it so there is an arcade like homepage, with a button panel, where you can select which game you want to play. And then if you click Flappy Bird, then you can play it, and if you clicked another game, you could play that game. That's my dream haha

* I didn't have that much refactoring, aside from reordering my methods to make the program run properly. 

* This project was fairly easy for me, and I feel like I was still able to show complexity of code, and clean code, and I created a game that I am proud of, and enjoyed making. I really enjoy Java, more so than I liked making front end things with react. This is really where I feel I excel. Java is methodical and picky, which are things I like about it. There is a lot of wiggle room with React and JavaScript, and I like the detailed aspect of Java very much. I really enjoyed making this project, even when I was stuck and frustrated. That is not how I felt about Capstone 1 with React. That was mostly just frustrating, and there wasn't much enjoyment. This code made me excitied, and I loved doing it! I feel like I was able to dig deeper into Java and learn new aspects of it that I wasn't aware of prior to this project. 
*
*
*