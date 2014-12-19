/* 
 * JavaScript to manage the JTable
 */

$(document).ready(function() { 
    //setup the jTable that will display the results
    $('#ParentTableContainer').jtable({
    	
        title: 'Parent Table',
        defaultSorting: 'Name ASC',
        paging: true, //Enable paging
        pageSize: 10, //Set page size (default: 10)
        sorting: true, //Enable sorting
        selecting: true, //Enable selecting
        multiselect: true, //Allow multiple selecting
        selectingCheckboxes: true, //Show checkboxes on first column
        columnResizable:true,
            actions: {
            	////listAction: 'parent/getAllStudent?class=&section=',
            listAction: 'parent/getAllParent',	
            createAction: 'parent/addParent',
            updateAction: 'parent/updateParent',
            deleteAction: 'parent/deleteParent'
        },
        fields: {
            ParentId: {
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
            Relation:{
            	title:'Relation',
            	list: true
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
            
            Education :{
            	title: 'Education',
            	list: true
            		
            },
            Occupation:{
            	title:'Occupation',
            	list : true
            		
            },
            Income :{
            	title:'Income',
            	list:true
            	
            },
            PresentAddress :{
            	title : 'PresentAddress',
            	display: function (data) {
	                return '<div style="width:82px;">' + data.record.PresentAddress +'</div>';
            	}
            	//list : true               	
            },
            PermanentAddress :{
            	title : 'PermanentAddress',
            	display: function (data) {
	                return '<div style="width:82px;">' + data.record.PermanentAddress +'</div>';
            	}
            	//list : true               	
            },
            City:{
            	title:'City',
            	list: true
            },
            State:{
            	title:'State',
            	list:true
            },
            Country:{
            	title:'Country',
            	list:true
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
            var $selectedRows = $('#PTableContainer').jtable('selectedRows');
            
            
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
                $('#ParentTableContainer').jtable('selectRows', data.row);
            }
        }
        
    });
    //Load student list from server
   $('#ParentTableContainer').jtable('load',{
    	
    });
     
  
});

