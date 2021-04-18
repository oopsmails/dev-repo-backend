# maven-plugin-jsonschema2pojo-ext

- This is actually a "mix-in" for jsonschema2pojo-maven-plugin

- This is only as an example for demoing mix-in of maven plugin, i.e, not working perfect

- Ref:
  https://stackoverflow.com/questions/60478946/maven-plugin-jsonschema2pojo-maven-plugin-not-generating-pojos-for-all-the-defin
  
## Usage

```
<plugin>
    <groupId>org.jsonschema2pojo</groupId>
    <artifactId>jsonschema2pojo-maven-plugin</artifactId>
    <version>1.0.2</version>
    <executions>
        <execution>
            <id>generateClassesFromSchema</id>
            <phase>generate-sources</phase>
            <goals>
                <goal>generate</goal>
            </goals>

        </execution>
    </executions>
    <configuration>
        // ...                            
        <customRuleFactory>my.package.JsonSchemaRuleFactory</customRuleFactory>
    </configuration>

    <dependencies>
        <dependency>
            <groupId>my.group</groupId>
            <artifactId>jsonschema-with-all-definitions</artifactId>
            <version>1.0.0</version>
        </dependency>
    </dependencies>
</plugin>
```

