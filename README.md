eoddata
=======

Java client for www.eoddata.com web service.

To be able to run the tests, you have to set your eoddata login and password in your local settings file. For example:

```xml
<settings>

  <profiles>

    <profile>
      <id>eoddata-client</id>
      <properties>
        <eoddata.login>my-eoddata-login</eoddata.login>
        <eoddata.password>my-eoddata-password</eoddata.password>
      </properties>
    </profile>

  </profiles>

  <activeProfiles>
    <activeProfile>eoddata-client</activeProfile>
  </activeProfiles>

</settings>
```
