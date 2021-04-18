# maven-plugin-jsonschema2pojo-ext

- This is actually a "mix-in" for jsonschema2pojo-maven-plugin

- This is only as an example for demoing mix-in of maven plugin, i.e, not working perfect

- Ref:
  https://stackoverflow.com/questions/60478946/maven-plugin-jsonschema2pojo-maven-plugin-not-generating-pojos-for-all-the-defin
  
## Usage: JsonSchemaRuleFactory

- This is a way of demoing how to deal with "extends" a superclass

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

## Usage: LombokAnnotator

- This is a way of demoing how to generate lombok annotations

- Json schema is also customized, see, spring-boot-java-main/src/main/resources/jsd/jsonSchema04-person-lombok.json

- Note: this includes a dependency of lombok, need to consider whether it should be excluded when using this mixin, thus, in real life this should be as a separate Jar.

```
<!--   This is for LombokAnnotator     -->
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <version>1.18.16</version>
    <!--<scope>provided</scope>-->
</dependency>
```



## Testing

- maven-plugins-dev-repo/maven-plugin-jsonschema2pojo-ext/pom.xml, run install
- maven-plugins-dev-repo/spring-boot-java-main/pom.xml, run package

