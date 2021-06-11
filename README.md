1.**Project Title:**

         •	This is to automate the flow of Pet API calls testing under https://petstore.swagger.io/ url
      
2.**Description:** 

         •	This project cover automation flow for 
      
         •	Upload an Image Module for existing Pet ID through “POST” request
       
         •	Add a new pet to the store through “Post” request
       
         •	Update an existing pet – To update details for an existing pet ID through “PUT” request
       
         •	Find pets by status – To find pets based on their availability status through “GET” request
       
         •	Find pet by ID – To find pets with pet ID through “GET” request
       
         •	Update a pet in the store with form data – To update form details for existing pet ID through “POST” request.
       
         •	Delete a pet – To delete an existing pet ID and corresponding entries through “DELETE” request.


3.**Prerequisites:**

         •	Download Java 8 (jdk1.8) version
   
         •	Download Apache Maven - 3.5.4
       
         •	Download Eclipse – Eclipse Oxygen
       
         •	Other External libraries are added as dependency in POM.xml file. It get downloaded automatically once the project is imported.
   
4.**Path of Project:**

         •	Testcase classes are under src/main/java/petStore_API
      
         •	Input file – json input files are under folder name jsonFiles
      
         •	In git repo, project is present under “master” branch
   
5.**Execution Flow**

                  Testcase name                             Module names
             * TC001_Post_Upload_Petimage             -This cover "Upload an Image" flow
             * TC002_Post_addANewPet                  -This cover "Add a new pet to the store" flow
             * Tc003_Put_updateAnExistingPet          -This cover "Update an existing pet" flow
             * TC004_Get_findPetByStatus              -This cover "Find pets by status" flow
             * TC005_Get_FindByPetID                  -This cover "Find pet by ID" flow
             * TC006_Post_updatePetWithFormData       -These covers "Update a pet in the store with form data" flow
             * TC007_Delete_DeleteAPet                -This cover "Delete a pet" flow
     
         •	The entire flow of the project can be executed from testngPetSwagger.xml file. This has test suite with all the test cases included
         •  Source of input is from json file, it read the data from json file and executes automatically.



