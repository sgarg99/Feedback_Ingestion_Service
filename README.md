<h4>High Level Design for Feedback Ingestion</h4>


Components



* Source - Exposed via public APIs
* Tenant - Each tenant can derive data from multiple sources.
* Feedback Pull Service -  Pull Feedback from different sources
* Tranformation Service - Transform the feedback data from various sources to a unified schema model
* Feeback Database - Stores the transformed feedback

Workflow



* Feedback pull service pull the data from the public API after a scheduled time 
* Feedback can also be pushed to the service which is exposed via HTTP APIs.
* The raw data is then passed to the transformation layer which converts the Source specific data to common schema.
* After the conversion the data is pushed to a Feedback Database or any other consumer.

Key Design Decisions



* Pulling the data at after a specific time interval due to the nature of the Feedback data which is not very time sensitive, so Batch Processing is a better choice



<p id="gdcalert1" ><span style="color: red; font-weight: bold">>>>>>  gd2md-html alert: inline image link here (to images/image1.png). Store image on your image server and adjust path/filename/extension if necessary. </span><br>(<a href="#">Back to top</a>)(<a href="#gdcalert2">Next alert</a>)<br><span style="color: red; font-weight: bold">>>>>> </span></p>


![alt_text](images/image1.png "image_tooltip")


<h4>Low Level Design</h4>


APIs

Add a tenant and tenant source configuration 



* Add a tenant
* Update a tenant
* Add tenant source configs like sourceType, topicId and additional parameters

<table>
  <tr>
  </tr>
</table>



    ```
POST /tenant/add
Request:
{
      tenantId : <string>
      tenantName : <string>	tenantConfigs : [{
	topicId : <string>
	sourceType : <enum>
            additionalInfo: {
                   key : value
              }
           }
        ]
 }
```



	

Add feedback 



* Give the tenant name, source type, and feedbackType
* Data is a raw feedback string consisting of key value pairs

    ```
POST /feedback/add
Request:
{
	tenantName : <string>
	sourceType : <enum>
	data : <string>
	feedbackType : <enum>
}
```



Get feedback



* Get All the feedback stored in the database

   


```
GET /feedback/getAll

Response:
[     
     {
        "tenantName": <string>
        "sourceType": <enum>
        "feedbackData": {
            "blurb": <string>
             key: value
          },
        "feedbackMetadata": {
            "id": <int>,
             key : value
          },
        "feedbackType": <enum>   
       }
]
```


Get feedback for a tenant


```
GET /feedback/getAllForTenant/tenantName
Response:
[     
     {
        "tenantName": <string>
        "sourceType": <enum>
        "feedbackData": {
            "blurb": <string>
             key: value
          },
        "feedbackMetadata": {
            "id": <int>,
             key : value
          },
        "feedbackType": <enum>   
       }}]
```

