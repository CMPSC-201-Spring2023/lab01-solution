# Getting to know Java

## Introduction

This assignment requires programmers to implement and test a Java program, called `AnalyzeText`, that will produce textual output demonstrating a simple analysis of a book. First, the program will display the name of the programmer and the date at which the program was run. Then, it will display the information about the book, such as its title, author, the number of words it has. Finally, the program will allow the user to search for specific keywords in the book. As verified by[Checkstyle](https://github.com/checkstyle/checkstyle), the source code for the `AnalyzeText.java` file must adhere to all of the requirements in the [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html).

The developer is also responsible for writing a reflection document, written in a Markdown language that adheres to the standards described in the [Markdown Syntax Guide](https://guides.github.com/features/mastering-markdown/) and answers the questions outlined in the template reflection document. Remember, you can preview the contents of a committed Markdown file by clicking on the name of the file in your GitHub repository.

The source code in the `AnalyzeText.java` file must also pass additional tests set by the [GatorGrader tool](https://github.com/GatorEducator/gatorgrade). GatorGrader will check the following characteristics of your implementation:

- The `AnalyzeText` program must:

  - Contain at least 10 single-line comments and 2 multi-line comments
  - Include at least 8 `println` statements
  - Use `new Scanner`, `new File`, `FileNotFoundException` commands.
  - Declare at least two `int` variables.
  - Utilize conditional `if` and repetition `while`statements.
  - Use at least one boolean OR expression.
  - Perform and display textual analysis of the book as outlined in the assignment sheet

When you use the `git commit` command to transfer your source code to your GitHub repository, [GitHub Actions](https://github.com/features/actions) will initialize a build of your assignment, checking to see if it meets all of the requirements. If both your source code and writing meet the established requirements, then you will see a green ✔ in the listing of commits in GitHub. If your submission does not meet the requirements, a red ✗ will appear instead. The instructor will reduce a programmer's grade for this assignment if the red ✗ appears on the last commit in GitHub immediately before the assignment's due date.

## Learning

If you have not done so already, please read all of the relevant [GitHub Guides](https://guides.github.com/) that explain how to use many of the features that GitHub provides. In particular, please make sure that you have read the following GitHub guides: [Mastering Markdown](https://guides.github.com/features/mastering-markdown/), [Hello World](https://guides.github.com/activities/hello-world/), and [Documenting Your Projects on GitHub](https://guides.github.com/features/wikis/). Each of these guides will help you to understand how to use both [GitHub](http://github.com) and [GitHub Classroom](https://classroom.github.com/).

To do well on this assignment, you should also review Chapter 1, 2, and 3 of the course textbook. Please see the course instructor or one of the technical leaders if you have questions about any of these reading assignments.

## Instructions

### Docker

In this course we will use Docker for an environment where we can compile and execute programs. This provides an environment with the languages that will be used in the class and ensures that everyone uses the same versions for help and grading purposes. If you do not have Docker set up from a previous class, please do so first.

• [Docker Mac Setup:](https:/docs.docker.com/docker-for-mac/install/) • [Docker Ubuntu Setup](https://www.digitalocean.com/community/tutorials/
how-to-install-and-use-docker-on-ubuntu-18-04) • [Docker Windows Setup:](https:/docs.docker.com/docker-for-windows/install/)

If the setup goes correctly as desired, you should be able to get started and validate the Docker version and run the hello world docker container using the following commands:

```
docker –version
docker run hello-world
```

### Running and Testing using Docker

Follow the instructions below, which can also be found at the `progator` Docker image link provided below, to get started. Additionally, please watch the lab introduction video for a working example of how to access the Docker image for this course and how to mount a directory as a volume.

[progator Docker Image](https://hub.docker.com/repository/docker/janyljumadinova/progator)

#### Pulling Image

Download automated build from public Docker Hub Registry:

`docker pull janyljumadinova/progator`

#### Running

`docker run -d -p 80:80 janyljumadinova/progator`

You can mount a directory as a volume with the argument *-v /your-path/directory/:/root/ like this :

`docker run -d -p 80:80 -v /your-path/local/working/directory/:/root/environment janyljumadinova/progator`

#### Accessing the IDE

<http://localhost>

### Working in the Localhost Window

Once you have localhost open in your browser, all other instructions will be completed in that window. If you close the window, just go to localhost again - you will not lose anything.

When you open localhost, you will see:

![](InstructionImages/Image1.png?raw=true)

On the left side, click on the Explorer icon (2nd down). Click Open Folder and enter "/root/" ![](InstructionImages/Image2.png?raw=true)

In the Explorer frame, right click, and click on Open in Integrated Terminal. ![](InstructionImages/Image3.png?raw=true)

You now have a terminal in which you can run most typical Linux commands. Ubuntu 20.04 is running with VSCode. Most work will be completed in the terminal. You are encouraged to mount a directory as a volume as described in the documentation at [progator Docker Image](https://hub.docker.com/repository/docker/janyljumadinova/progator) so that you can have access to your local repository files, which can be accessed from the "environment" directory in "root".

Please remember to stop the container after you are finished working in it. You can use the command: `docker container list` to see the ID of the running container, and `docker container stop container-ID` to stop the container by replacing `container-ID` with its actual ID.

### Program Overview

This lab invites programmers to implement a Java program that analyzes a large body of text automatically. First, your program will calculate and output some statistics about the book, specifically the title, author, year information if available, and the number of words in a book of your choosing. Then, you will implement a searching functionality for the user to look up specific information and the number of its occurrences in the book. To get started, download a book or two--I have added a few books into the lab repository's /input directory, or you can visit [Project Gutenberg](http://www.gutenberg.org/) and pick some other classics. Then write a Java program that prints out information about the book, calculates the number of words in the book, and allows the user to search to book based on specified keywords as described below.

### Displaying Information About a Book

Once you have chosen the book you would like to analyze, change the `fileName` variable's assignment to point to your chosen book. Then, open the text file of your book and check where preamble information regarding the title, author, etc. is located; make a note of the number of lines this information occupies at the beginning of the document. Then, modify the value assigned to the `preambleLines` variable according to this number of lines to ensure you display all relevant information. Finally, using a `while` loop, read and print these first few lines of the document.

### Calculating the Number of Words in a Book

We all know that books can have lots of words. For instance, "War and Peace" has somewhere between 560,000 and 580,000 words, depending on the translation. But how can you automatically count the number of words in a book? During this lab you will develop a solution to this question.

First, the program needs to read the file until the end of the file. There are several ways to read words from a text file. One way to do this is to use a `try/catch` block and a `File` and a `Scanner` to read a file. Then, as you are reading each word from the file you should count it. Please omit the preamble with the title, author, year and other information. You should only count the words in the text of the book directly.

**Can we do better?** Yes, we can do better--for instance, punctuation such as quotation marks, periods, commas, etc., will be read in as part of some of the words. That means that things like "however," and "however." will be treated as two distinct words. Can you eliminate this problem? Here are a couple of possible approaches:

1. Use `String` class's replace method to replace all commas and periods with space.
2. The `Character` class, which is the wrapper class for `char`, has a `boolean` method named `isLetter`; you might use it like this:

  ```
  ...
  char c = w.charAt(i);  // get the i-th character of w
  if (Character.isLetter(c)) { // see if c is a letter
  ... do something
  }
  ```

### Searching Functionality

Now, you can implement a searching functionality to allow the user to search the text for two keywords and display lines of text with those keywords along with the count of occurrences of those keywords. Use the class program called SearchText as an inspiration for this algorithm. Please note that you will have to re-initialize the `Scanner` object if using the same Scanner variable from the previous step, since in the previous step the Scanner has read through the whole document and is now at the end of the file, so we need to make it start from the beginning of the document again. Otherwise, you can create a brand new Scanner variable.

### Program Requirements

You should design and implement a Java program that does the following.

1. Display the preamble information about the book, including the book's title and the author.
2. Count the number of words (excluding punctuation) in the book and display this information to the terminal.
3. Read in two keywords from the user to utilize in the search and save them into two String variables.
4. Count the number of occurrences of the user's keywords in the book and display the text lines containing them.
5. Print an exit message.

The following gives a sample run of a previously implemented version of the program. Your output should be different! Please see the course instructor if you do not understand this program's output.

```
Janyl Jumadinova Wed Jan 09 17:04:29 EDT 2023
ULYSSES S. GRANT
BY
WALTER ALLEN
There are 27910 number of words in this book
Please enter two single keywords
time
life
Occurrence # 0: extended, in its destruction of life and waste of property, in the
Occurrence # 1: on which there may always be two opinions. As time passes, and the
Occurrence # 2: chastened judgment of coming time, will appear to all men, as even now
Occurrence # 3: In the story of Grant’s life some things must be told that are not at
... omitted for space ...
Occurrence # 80: disposition than the narration for the public of his own life story. But
Occurrence # 81: in his circumstances, the question was not one of sentiment, but only of
Occurrence # 82: outward manifestations of his life.
Occurrence # 83: people in all walks of life.
Keywords "time" and "life" appeared 84 number of times.
Thank you for using the AnalyzeText program.
 Have a wonderful day.
```

## Assignment Assessment

The grade that a student receives on this assignment will have the following components.

- **GitHub Actions CI Build Status [up to 30%]:**: For lab01 repository associated with this assignment students will receive a checkmark grade if their last before-the-deadline build passes.

- **Mastery of Technical Writing [up to 20%]:**: Students will also receive a checkmark grade when the responses to the writing questions presented in the `reflections.md` reveal a proficiency of both writing skills and technical knowledge. To receive a checkmark grade, the submitted writing should have correct spelling, grammar, and punctuation in addition to following the rules of Markdown and providing conceptually and technically accurate answers.

- **Mastery of Technical Knowledge and Skills [up to 50%]**: Students will receive a portion of their assignment grade when their lab implementation reveals that they have mastered all of the technical knowledge and skills developed during the completion of this assignment. As a part of this grade, the instructor will assess aspects of the project including, but not limited to, the completeness and correctness of the program, the use of effective source code comments and Git commit messages.

All grades for this project will be reported through a student's gradebook GitHub repository.

## GatorGrade

You can check the baseline writing and implementation requirements of this project by running department's assignment checking `gatorgrade` tool To use `gatorgrade`, you first need to make sure you have Python installed. If not, please see:

- [Setting Up Python on Windows](https://realpython.com/lessons/python-windows-setup/)
- [Python 3 Installation and Setup Guide](https://realpython.com/installing-python/)
- [How to Install Python 3 and Set Up a Local Programming Environment on Windows 10](https://www.digitalocean.com/community/tutorials/how-to-install-python-3-and-set-up-a-local-programming-environment-on-windows-10)

Then, you need to install `gatorgrade`:

- First, [install `pipx`](https://pypa.github.io/pipx/installation/)
- Then, install `gatorgrade` with `pipx install gatorgrade`

Finally, you can run `gatorgrade`:

`gatorgrade --config config/gatorgrade.yml`

## Assistance

If you are having trouble completing any part of this project, then please talk with the course instructor or technical leaders during the laboratory session. Alternatively, you may ask questions in the Discord channel for this course. Finally, you can schedule a meeting during the course instructor's office hours.
