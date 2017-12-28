# Overview
This project is a sample that helps to showcase how Spring supports [Amazon ElastiCache (Redis)](https://aws.amazon.com/elasticache/).  Using the proper annotations, data can be temporarily stored in Redis for faster access. 

# Guidebook
Details about this project are contained in the [guidebook](guidebook/guidebook.md) and should be considered mandatory reading prior to contributing to this project.

# Prerequisites
* [JDK 8](http://zulu.org/) installed and working
* a configured ElastiCache -- a single server is fine but a cluster works just as well 

# Building
`./gradlew` will pull down any dependencies, compile the source and package everything up.

# Installation
Nothing to install.

# Tips and Tricks
## Starting The Server
Edit `application.yml`, inserting your API keys.

**TODO:** add output from the program 

# Troubleshooting
## Network Access
ElastiCache is only accessible from within a VPC [unless special configurations are in place](http://docs.aws.amazon.com/AmazonElastiCache/latest/UserGuide/Access.Outside.html).

# Contributing

# License and Credits
* This project is licensed under the [Apache License Version 2.0, January 2004](http://www.apache.org/licenses/).
* The guidebook structure was created by [Simon Brown](http://simonbrown.je/) as part of his work on the [C4 Architectural Model](https://c4model.com/).  His books can be [purchased from LeanPub](https://leanpub.com/b/software-architecture).
* Patrick Kua offered [his thoughts on a travel guide to a software system](https://www.safaribooksonline.com/library/view/oreilly-software-architecture/9781491985274/video315451.html) which has been [captured in this template](travel-guide/travel-guide.md).

# List of Changes
