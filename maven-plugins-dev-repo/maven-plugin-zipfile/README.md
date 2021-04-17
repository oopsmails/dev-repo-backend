# maven-plugin-zipfile

- Ref:

https://dzone.com/articles/beginners-guide-to-creating-a-maven-plugin

## Usage example

```
<plugin>
    <groupId>com.oopsmails.mavenplugins.dev.repo</groupId>
    <artifactId>maven-plugin-zipfile</artifactId>
    <version>1.0-SNAPSHOT</version>
    <executions>
        <execution>
            <configuration>

                <input>${project.basedir}/src/main/resources</input>
                <zipName>test-maven-plugin-zip</zipName>

            </configuration>
            <goals>
                <goal>zip</goal>
            </goals>
        </execution>
    </executions>
</plugin>
```

