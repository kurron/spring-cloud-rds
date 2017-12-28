# Overview
This project is a sample that helps to showcase how Spring supports [Amazon Relational Database Service](https://aws.amazon.com/rds/).  Hibernate is the ORM that sits atop the Spring infrastructure managing the connection to RDS. 

# Guidebook
Details about this project are contained in the [guidebook](guidebook/guidebook.md) and should be considered mandatory reading prior to contributing to this project.

# Prerequisites
* [JDK 8](http://zulu.org/) installed and working
* a configured RDS instance (MySQL) 

# Building
`./gradlew` will pull down any dependencies, compile the source and package everything up.

# Installation
Nothing to install.

# Tips and Tricks
## Starting The Server
Edit `application.yml`, inserting your API keys.

**TODO:** add output from the program 

# Troubleshooting

# Contributing

# License and Credits
* This project is licensed under the [Apache License Version 2.0, January 2004](http://www.apache.org/licenses/).
* The guidebook structure was created by [Simon Brown](http://simonbrown.je/) as part of his work on the [C4 Architectural Model](https://c4model.com/).  His books can be [purchased from LeanPub](https://leanpub.com/b/software-architecture).
* Patrick Kua offered [his thoughts on a travel guide to a software system](https://www.safaribooksonline.com/library/view/oreilly-software-architecture/9781491985274/video315451.html) which has been [captured in this template](travel-guide/travel-guide.md).

# List of Changes
