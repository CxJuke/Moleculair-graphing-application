# Molecular graph webapp

This product gives a website with an input bar to type a molecule. While you are typing the molecule, the molecule is drawn on the website with nodes and edges.
If you are satisfied with your molecule, it's possible to save it with the moleculename in a database to use it.

## Getting started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. See deployment for notes on how to deploy the project on a live system.

### Prerequisites

What things you need to install the software and how to install them.

* [Java 10](https://www.oracle.com/technetwork/java/javase/downloads/java-archive-javase10-4425482.html)
* [Tomcat server](http://tomcat.apache.org/)
* [Sqlite database](https://www.sqlite.org/index.html)
* [Python 3.5](https://www.python.org/downloads/release/python-350/)

### Installing
A step by step series of examples that tell you how to get a development env running

```
git clone https://Pkamphuis@bitbucket.org/Pkamphuis/molecular_graphing-webapplication.git
```

### Usage
Start in IntellJ and run index.jsp with the TomCat server to get the webpage.

Add the following parameters to the web.xml file: 
* pythonVenv (path to python 3.5)
* grappa.path (path to the grappa.py file)
* database (path to sqlite database)

The following string is a molecule to test the website: "H1 C1(/#=2-4/(C#(H#[1-3]),)/)" or "\<PHE>" as example for a complete aminoacid.

## Deployment
Add additional notes about how to deploy this on a live system

## Built with
* [Gradle](https://gradle.org/)

## Authors

* **Jouke Profijt** - [JoukeProfijt](https://bitbucket.org/JoukeProfijt/)
* **Priscilla Kamphuis** - [Pkamphuis](https://bitbucket.org/Pkamphuis/)


## License
Copyright (c) 2018 <Priscilla Kamphuis and Jouke Profijt>.
Licensed under GPLv3. See gpl.md


## Acknowledgments

* [Grappa by Tsjerk Wassenaar](https://github.com/marrink-lab/vermouth-martinize/tree/master/vermouth/graphing)