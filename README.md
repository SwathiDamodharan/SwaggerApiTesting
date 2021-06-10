# SwaggerApiTesting
    * Purpose of this project 
        This project automates backend api calls for all modules of pet section under "https://petstore.swagger.io/#/"
        For each module, each seperate testcase class file has been created
     
             Testcase name                   -              Module names 
        1) TC001_Post_Upload_Petimage        -  This cover "Upload an Image" module
        2) TC002_Post_addANewPet             -  This cover "Add a new pet to the store" module
        3) Tc003_Put_updateAnExistingPet     -  This cover "Update an existing pet" module
        4) TC004_Get_findPetByStatus         -  This cover "Find pets by status" module
        5) TC005_Get_FindByPetID             -  This cover "Find pet By ID" module
        6) TC006_Post_updatePetWithFormData  -  This covers "Update apet in the store with form data" module
        7) TC007_Delete_DeleteAPet -         -  This cover "Delete a pet" module

    * Path of testcases:
        Its under scr/main/java/petStore_API
    * jsonFiles:
        This folder contain all input jsonFiles
    * testngPetSwagger.xml:
        This is testng file. I have converted all the testcases into this file. All the testcases can be executed at one go from this file.
    * driver:
        This has exe file for chromedriver(chrome version - 91.0.44)
    * This is a maven project with all dependencies on pom.xml
    * Version or java - jdk1.8
    * Version of maven - 3.5.4
    * All other jar files version can be found under Pom.xml file
