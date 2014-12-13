/* 
 * JavaScript to manage the JTable
 */

$(document).ready(function() { 
    //setup the jTable that will display the results
    $('#EmployeeTableContainer').jtable({
    	
        title: 'Employee Table',
        defaultSorting: 'Name ASC',
        paging: true, //Enable paging
        pageSize: 10, //Set page size (default: 10)
        sorting: true, //Enable sorting
        selecting: true, //Enable selecting
        multiselect: true, //Allow multiple selecting
        selectingCheckboxes: true, //Show checkboxes on first column
        columnResizable:true,
            actions: {
            //listAction: 'student/getAllStudent?class=&section=',
            listAction: 'employee/getAllEmployee',	
            createAction: 'employee/addEmployee',
            updateAction: 'employee/updateEmployee',
            deleteAction: 'employee/deleteEmployee'
        },
        fields: {
            EmployeeId: {
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
            Gender: {
                title: 'Gender',
                options: { 'M': 'Male', 'F': 'Female' },
                list: false
            },
            Department:{
            	title:'Department',
            	options:{'English':'English','Hindi':'Hindi','Mathematics':'Mathematics','physics':'physics','chemistry':'chemistry'},
            	list:false
            	
            },
            Category:{
            	title:'Category',
            	options:{'OfficeStaff':'OfficeStaff','Teacher':'Teacher'},
            	list:false
            	
            },
            Position:{
            	title:'Position',
            	options:{'':'select','General':'General'},
            	list:false
            	
            },
            Grade:{
            	title:'Grade',
            	options:{'':'select','A':'A','B':'B','C':'C','D':'D','E':'E'},
            	list:false
            },
            JobTitle:{
            	title:'JobTitle',
            	list:false
            },
            Qualification:{
            	title:'Qualification',
            	list:false
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
            ExperienceInfo:{
            	title:'expInfo',
            	list:false
            	
            },
            Photo: {
            	title: 'photo',       	
            	method:'post',
           		enctype:'multipart/form-data',
            	input: function (data) {    
            	return  '<input type="file" name="photo">';
            	'<input type="submit" value="Upload" id="submitBtn" />';
            	  },
            	  display: function (data) {
		                return '<div style="width:82px;">' + data.record.Photo +'</div>';
            	  }
            	}          
        },
        selectionChanged: function () {
            //Get all selected rows
            var $selectedRows = $('#EmployeeTableContainer').jtable('selectedRows');
            
            
            $('#SelectedRowList').empty();
            if ($selectedRows.length > 0) {
                //Show selected rows
            	var i=0;
                $selectedRows.each(function () {
                	
                    var record = $(this).data('record');
                    custData[i]=record.EmployeeId;
                    i++;
                    
                   
                    $('#SelectedRowList').append(
                        '<b>EmployeeId</b>: ' + record.EmployeeId +
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
                $('#EmployeeTableContainer').jtable('selectRows', data.row);
            }
        }
        
    });
    //Load student list from server
   $('#EmployeeTableContainer').jtable('load',{
    	
    });
     
   /* $('#LoadRecordsButton').click(function (e) {
        e.preventDefault();
        $('#EmployeeTableContainer').jtable('load', {
            name: $('#name').val(),
            'className': $('#classSelected').val()
        });
    });
    $('#LoadRecordsButton').click();
                */
});

