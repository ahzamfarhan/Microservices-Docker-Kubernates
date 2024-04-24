
{
   "firstName":"",
   "lastName":"",
   "birthDate":"",
   "deptId":
}


Parsing error Date is not deserialized to Local Date.

	Solution
	
		<dependency>
		    <groupId>com.fasterxml.jackson.datatype</groupId>
		    <artifactId>jackson-datatype-jsr310</artifactId>
		    <version>2.17.0</version>
		</dependency>

		public class EmployeeSignupDto {

			private String firstName;
			private String lastName;
			
			@DateTimeFormat(pattern = "dd-MM-yyyy")
			@JsonDeserialize(using = LocalDateDeserializer.class)
			@JsonSerialize(using = LocalDateSerializer.class)
			@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
			private LocalDate birthDate;
			
			private long deptId;
	
			
			//Getter and Setters
	
		}	

	Site
	
		


JPA and DB related error removed.


	Solution
	
		@Id
 		@GeneratedValue(strategy = GenerationType.IDENTITY)
 		private Long id;
		
		
	Site
		
		https://stackoverflow.com/questions/49813666/table-dbname-hibernate-sequence-doesnt-exist
		

	Solution
	
		alter table employee modify column productId int NOT NULL AUTO_INCREMENT;
	
	Site
	
		
		https://stackoverflow.com/questions/26336520/java-sql-sqlexception-field-supplier-id-doesnt-have-a-default-value
		
		
		
		

	