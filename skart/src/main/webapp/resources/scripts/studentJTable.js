/* 
 * Javascript to manage the JTable
 */

$(document).ready(function() {              
    //setup the jtable that will display the results
    $('#StudentTableContainer').jtable({
        title: 'Student Table',
        defaultSorting: 'Name ASC',
        selecting: true, //Enable selecting 
        paging: true, //Enable paging
        pageSize: 10, //Set page size (default: 10)
        sorting: true, //Enable sorting
        columnResizable:true,
        actions: {
            listAction: 'student/getAllStudent',
            createAction: 'student/addStudent',
            updateAction: 'student/updateStudent',
            deleteAction: 'student/deleteStudent'
        },
        fields: {
            StudentId: {
                title: 'ID',
                key: true,
                list: false,
                create: false,
                edit: false
                
            },
            Name :{
            	title:'Name',
            	
            },
            ClassName:{
            	title: 'Class'
            	
            	/*display: function(data){
            		if (data.record.ClassName="Class" return 'inline-block')*/
            },
            Section :{
            	title: 'Section', 	
            display: function (data) {
                return '<div style="width:82px;">' + data.record.Section +'</div>';
            }
            	//width :'9%'
            	
            },
            DateOfBirth :{
				title : ' DOB',
				list :true,
				type :'date',
				displayFormate : 'yy-mm-dd',
				//width :'8%'
				
            },
            BloadGroup :{
            	title :'B-G',
            	list : true,
            	options : {'':'select','O+':'O+','O-':'O-','A+':'A+','A-':'A-','B+':'B+','B-':'B-','AB+':'AB+','AB-':'AB-'},
            	//width :'8%'
            },
            CurrentAttendance :{
            	title :'Current Attendence',
            	//list: false
            },
            OveralAttendance :{
            	title :'Overall Attendance',
            	//list: false
            	
            },
            PerformanceRating :{
            	title :'Rating',
            	//list: false,
            	//width :'9%'
            },
            ParentName : {
            	title : 'ParentName'
            	
            },
            Address :{
            	title : 'Address',
            	//list : true               	
            },
            MobilePhone :{
            	title : 'Mobile'
            	
            },
            Email :{
            	title: 'Email'
            	
            },
           photo: {
            	title: 'photo',
            	input: function (data) {    
            	return  '<input type="file" name="file">';
            	'<input type="submit" value="Submit" id="submitBtn" />';
            	  },
            	}
            /*Photo: {
                title: "Photo",
                width: '50%',
                edit: true,
                create: true,
                display: function (data) {
                      return '<img src=' + data.record.ImageURL + ' />';
                 },
       }*/
           
        }
//        //Register to selectionChanged event to hanlde events                                     '
//        recordAdded: function(event, data){
//            //after record insertion, reload the records
//            $('#StudentTableContainer').jtable('load');
//        },
//        recordUpdated: function(event, data){
//            //after record updation, reload the records
//            $('#StudentTableContainer').jtable('load');
//        }
        
        
    });
    //Load student list from server
   // $('#StudentTableContainer').jtable('load');
    
    $('#LoadRecordsButton').click(function (e) {
        e.preventDefault();
        $('#StudentTableContainer').jtable('load', {
            name: $('#name').val(),
            className: $('#className').val()
        });
    });
    $('#LoadRecordsButton').click();
                
});
