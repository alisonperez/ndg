The NDG project is made up of various modules which combine to make the whole application.

The server modules are:

  ndg-commons-core
  ndg-server-core
  ndg-server-servlets
  ndg-web-server
  
The web client module is:

  ndg-web-ui
  
The mobile client module is:

  ndg-mobile-client
  
The release includes the source code to create the .jar files on which NDG depends. 
  
Some modules can have Java .jar files added into the lib directory. Some of these are optional and others provide core functionality which the NDG software uses. For each module we use we have specified the location, the .jar name, give a short description and the software license: 

1. ndg-commons-core/lib
  (Optional) junit.jar - A unit testing framework for writing repeatable tests  - Released Common Public License v 1.0
  (Optional) commons-logging-1.0.4.jar - A modular bridging API with support for most well known logging system - Apache License, Version 2.0 (http://www.apache.org/licenses/LICENSE-2.0)
  
2. ndg-mobile-client/lib
  (Required) kxml2-2.3.0.jar - kXML is a lean Common XML API with namespace and WAP support - Source code included
  (Required) LWUIT.jar - UI Toolkit (Binary Distribution) - The early access binary library is Licensed under the Sun License Agreement (SLA). This license enables you to use the library in commercial products for free. The source code is not included but the binary needs to be in this folder
  
3. ndg-server-core/lib
  (Required) indt-smslib.jar - (explained above) HTTP Classes and methods written by INdT which interact with the mobile broker Clickatell (http://www.clickatell.com/) - source code included
  (Required) mail.jar - provides a platform-independent and protocol-independent API framework to build mail and messaging applications - CDDL license and the GPLv2 with Classpath Exception
  (Required) smslib-3.3.0.jar - SMSLib is a programmer's library for sending and receiving SMS messages via a GSM modem or mobile phone - Apache License, Version 2.0 
  
4. ndg-web-server/WebContent/WEB-INF/lib contains various .jar files which are part of the flex toolkit. These are all released by Adobe under the Mozilla Public License (http://www.mozilla.org/MPL/). The .jars are all (Required) to be able to compile the server UI

 cfgatewayadapter.jar
 xalan.jar
 commons-logging.jar
 flex-messaging-core.jar
 flex-messaging-opt.jar
 concurrent.jar
 commons-codec-1.3.jar
 flex-messaging-remoting.jar
 flex-messaging-common.jar
 backport-util-concurrent.jar
 flex-messaging-proxy.jar
 commons-httpclient-3.0.1.jar

5. ndg-server-servlets/WebContent/client/ndg.jar
  (Optional) the downloadable mobile client which is offered as a download after user registration. This .jar is created by the ndg-mobile-client module
  

  

