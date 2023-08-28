Generate Cucumber report:

Run : mvn clean install -Dthread=2 with two browser

if you wanna run parrallel execution the number of feature shuold greater than Thread you execution

1- download maven : https://maven.apache.org/download.cgi
2- Setup maven environment (user or system veriable)
3- Check maven version
4- add:
				<build>
						<plugins>
							<plugin>
								<groupId>org.apache.maven.plugins</groupId>
								<artifactId>maven-surefire-plugin</artifactId>
								<version>2.22.0</version>
								<configuration>
									<testFailureIgnore>true</testFailureIgnore>
								</configuration>
							</plugin>
							<plugin>
								<groupId>net.masterthought</groupId>
								<artifactId>maven-cucumber-reporting</artifactId>
								<version>2.8.0</version>
								<executions>
									<execution>
										<id>execution</id>
										<phase>verify</phase>
										<goals>
											<goal>generate</goal>
										</goals>
										<configuration>
											<projectName>autoBasic</projectName>
											<outputDirectory>${project.build.directory}/cucumber-report-html</outputDirectory>
											<cucumberOutput>${project.build.directory}/cucumber.json</cucumberOutput>
										</configuration>
									</execution>
								</executions>
							</plugin>
						</plugins>
					</build>
-------------------------------------------------------------------
<projectName>autoBasic</projectName> => update project name currently

Add
	<properties>
		<maven.compiler.source>1.8</maven.compiler.source>
		<maven.compiler.target>1.8</maven.compiler.target>
	</properties>
---------------------------------------------------------------------

5- Run mvn clean test (generate json report) (right-click to run as maven test)// maven clean trên thanh menu bar t => clean
6- Run mvn verify -DskipTests (generate report base in json file)
=> verify is text in <phrase> above

OR using mvn clean install => auto generate report
----

switch evn: mvn clean insatll -PQA
run test: mvn test -Dbrowser=chrome


Dcucumber.options="src/test/resources/functionalTests/End2End_Tests.feature" 
-Dcucumber.options="--tags @Smoke"


Fix error: When maven says "resolution will not be reattempted until the update interval of MyRepo has elapsed", where is that interval specified?
	mvn -U clean install
	(where -U will force update the repo)
	Iff you wanna use this dependence you must run mvn clean insatll again

					
					
If you meet error "hamcrest" library conflict
you should check import on the file: 
Should import: import static io.restassured.RestAssured.given;
Not import: import static io.restassured.RestAssured.*;



					
