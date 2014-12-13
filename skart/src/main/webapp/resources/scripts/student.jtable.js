/* 
 * JavaScript to manage the JTable
 */

$(document).ready(function() { 
    //setup the jTable that will display the results
    $('#StudentTableContainer').jtable({
    	
        title: 'Student Table',
        defaultSorting: 'Name ASC',
        paging: true, //Enable paging
        pageSize: 10, //Set page size (default: 10)
        sorting: true, //Enable sorting
        selecting: true, //Enable selecting
        multiselect: true, //Allow multiple selecting
        selectingCheckboxes: true, //Show checkboxes on first column
        columnResizable:true,
            actions: {
            listAction: 'student/getAllStudent?class=&section=',
            ////listAction: 'student/getAllStudent',	
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
            	 /*display: function (data) {
                     return '<div style="width:82px;">' + data.record.Name +'</div>';
                 }*/
            	
            },
            ClassName:{
            	title: 'Class',
            	options:{'1st Class':'1st Class','2nd Class':'2nd Class','3rd Class':'3rd Class','4th Class':'4th Class','5th Class':'5th Class','6th Class':'6th Class','7th Class':'7th Class','8th Class':'8th Class','9th Class':'9th Class','10th Class':'10th Class'},
            	display: function (data) {
                    return '<div style="width:82px;">' + data.record.ClassName +'</div>';
                }
            	
            	
            },
            Section :{
            	title: 'Section',
            	options:{'A':'A','B':'B','C':'C','D':'D'},
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
				changeYear:true,
				changeMonth:true,
				 display: function (data) {
		                return '<div style="width:82px;">' + data.record.DateOfBirth +'</div>';
				 }
				//width :'8%'
				
            },
            DateOfJoning :{
				title : ' DOJ',
				list :true,
				type :'date',
				displayFormate : 'yy-mm-dd',
				changeYear:true,
				changeMonth:true,
				display: function (data) {
	                return '<div style="width:82px;">' + data.record.DateOfJoning +'</div>';
				}
            	
            },
            BloadGroup :{
            	title :'B-G',
            	list : true,
            	options : {'':'select','O+':'O+','O-':'O-','A+':'A+','A-':'A-','B+':'B+','B-':'B-','AB+':'AB+','AB-':'AB-'},
            	display: function (data) {
	                return '<div style="width:82px;">' + data.record.BloadGroup +'</div>';
            	}
            	
            	//width :'8%'
            },
            CurrentAttendance :{
            	title :'Current Attendence',
            	display: function (data) {
	                return '<div style="width:82px;">' + data.record.CurrentAttendance +'</div>';
            	}
            	//list: false
            },
            OveralAttendance :{
            	title :'Overall Attendance',
            	display: function (data) {
	                return '<div style="width:82px;">' + data.record.OveralAttendance +'</div>';
            	}
            	//list: false
            	
            },
            PerformanceRating :{
            	title :'Rating',
            	display: function (data) {
	                return '<div style="width:82px;">' + data.record.PerformanceRating +'</div>';
            	}
            	//list: false,
            	//width :'9%'
            },
            ParentName : {
            	title : 'ParentName',
            	/*display: function (data) {
	                return '<div style="width:82px;">' + data.record.ParentName +'</div>';
            	}*/
            	
            },
            Address :{
            	title : 'Address',
            	display: function (data) {
	                return '<div style="width:82px;">' + data.record.Address +'</div>';
            	}
            	//list : true               	
            },
            MobilePhone :{
            	title : 'Mobile',
            	display: function (data) {
	                return '<div style="width:82px;">' + data.record.MobilePhone +'</div>';
            	}
            	
            },
            Email :{
            	title: 'Email',
            	/*display: function (data) {
	                return '<div style="width:82px;">' + data.record.Email +'</div>';
            	}*/
            	
            },
            Photo: {
            	title: 'photo',       	
            	method:'post',
           		enctype:'multipart/form-data',
            	input: function (data) {    
            	return '<button type="button" id="photoBtn" onClick="photoClick();">Upload </button>';
            	
            	  },
            	  display: function (data) {
		                return  '<img src = "'+data.record.Photo+'">';
            	  }
            	}          
        },
        selectionChanged: function () {
            //Get all selected rows
            var $selectedRows = $('#StudentTableContainer').jtable('selectedRows');
            
            
            $('#SelectedRowList').empty();
            if ($selectedRows.length > 0) {
                //Show selected rows
            	var i=0;
                $selectedRows.each(function () {
                	
                    var record = $(this).data('record');
                    custData[i]=record.StudentId;
                    i++;
                    
                   
                    $('#SelectedRowList').append(
                        '<b>StudentId</b>: ' + record.StudentId +
                        '<br /><b>Name</b>:' + record.Name + '<br /><br />'
                        
                        
                        );
                });
            } else {
                //No rows selected
                $('#SelectedRowList').append('No row selected! Select rows to see here...');
            };
        },
        rowInserted: function (event, data) {
            if (data.record.Name.indexOf('Andrew') >= 0) {
                $('#StudentTableContainer').jtable('selectRows', data.row);
            }
        }
        
    });
    //Load student list from server
   $('#StudentTableContainer').jtable('load',{
    	
    });
     
   /* $('#LoadRecordsButton').click(function (e) {
        e.preventDefault();
        $('#StudentTableContainer').jtable('load', {
            name: $('#name').val(),
            'className': $('#classSelected').val()
        });
    });
    $('#LoadRecordsButton').click();
                */
});

