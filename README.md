# Molecular graph webapp

This product gives a website with an input bar to type a molecule. While you are typing the molecule, the molecule is drawn on the website with nodes and edges.
If you are satisfied with your molecule, it's possible to save it with the moleculename in a database to use it.

## Getting started

```
git clone https://Pkamphuis@bitbucket.org/Pkamphuis/molecular_graphing-webapplication.git
```

### Prerequisites

What things you need to install the software and how to install them.

* [Java 10](https://www.oracle.com/technetwork/java/javase/downloads/java-archive-javase10-4425482.html)
* [Tomcat server](http://tomcat.apache.org/)
* [Sqlite database](https://www.sqlite.org/index.html)
* [Python 3.5](https://www.python.org/downloads/release/python-350/)

### Installing

After cloning you are required to create a working python virtual enviroment with the following packages:

* sphinx >= 1.8.0

* sphinxcontrib-apidoc

* pbr

* setuptools >= 30.3.0

* numpy

* networkx ~= 2.0

* scipy
These packages are required for vermouth-martinize where we are using grappa.py from.
So also install [vermouth-martinize](https://github.com/marrink-lab/vermouth-martinize) into the enviroment.


### Usage
Start in IntellJ and run index.jsp with the TomCat server to get the webpage.

Add the following parameters to the web.xml file: 
* pythonVenv (path to virtual enviorment you created in installing section)

* grappa.path (path to the grappa.py file, usually src/main/python/grappa.py)

* database (path to sqlite database, usually src/main/webapp/data/molecules.sqlite)


The following string is a molecule to test the website: "H1 C1(/#=2-4/(C#(H#[1-3]),)/)" or "\<PHE>" as example for a complete aminoacid.

If the user wants premade molecules with proper names to use in the search function run the src/main/webapp/data/database.sql script in the molecules.sqlite database.

```
sqlite3 src/main/webapp/data/molecules.sqlite
sqlite> .read src/main/webapp/data/database.sql
```

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