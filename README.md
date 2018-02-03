# atm-java

How to build and run this application
1. Clone project to your machine.
2. Go to root directory of this application.
3. Install gradle in your maching.
3. Issue 'gradle run' in your prefer CLI tools.

This application uses following libraries
1. 'com.google.inject', name: 'guice', version: '4.1.0' : for dependency injection purpose which helps project more loosely coupled and makes unit test easier.
2. 'junit', name: 'junit', version: '4.12' : for testing purpose.
3. 'org.mockito:mockito-core:2.13.0' : for unit test purpose which makes object mocking easier.
4. 'com.typesafe:config:1.3.2' : for flexibility of the application by providing configuration way via application.conf file.

*Note*
- You can config amount of each notes in this ATM by application.conf file before starting application.