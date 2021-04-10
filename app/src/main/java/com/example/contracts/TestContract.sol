// SPDX-License-Identifier: GPL-3.0
pragma solidity ^0.8.3;


contract D_Health_Block{
    
    uint256 pID=0;
    
    struct patient {
        uint256 id;
        string name;
        uint256 adhar;
        address account_address;
        
    }
    struct patientData{
        
        string name_of_doc;
        string hospital;
        uint256 license;
        uint256 date;
        string disease;
    }
    
    struct doctor{
        uint256 license;
        string name;
        string hospital;
        
    }
    
    mapping (uint256 => bool) licenseExists;
    
    mapping(uint256 => patient) public pMap;
    mapping(uint256 => doctor) public dMap;
    
    
    mapping(uint256 => patient[]) public pDataList;
    mapping(uint256 => doctor[]) public dDataList;
    
    // patientData newData;
    // function addPatientData(uint256 _id, string memory _doc_name, string memory _hospital, uint256 _license, uint256 _date, string memory _disease) public {
        
    //     pDataList[_id].push(patientData(
    //         {
    //             name_of_doc:_doc_name,
    //             hospital:_hospital,
    //             license:_license,
    //             date:_date,
    //             disease:_disease
                
    //         })
    //     );
    // }
    
    // function getSinglePatientData(uint256 _id) public{
        
    // }
    
    patient newPatient;
    function createPatient(string memory _name,uint256 _adhar,address _account_address) public {
      
        newPatient = patient(pID,_name,_adhar,_account_address);
        pMap[pID]=newPatient;
        pID++;
        
    }
    
    function updatePatient(uint256 _id,string memory _name,uint256 _adhar,address _account_address) public {
        
        require(_id>pID,"Patient with given ID doesn't exist");
        
        pMap[_id].name=_name;
        pMap[_id].adhar=_adhar;
        pMap[_id].account_address=_account_address;
    }
    
    doctor newDoctor;
    function createDoctor(uint256 _license,string memory _name,string memory _hospital) public {
        
        require(licenseExists[_license]==false, "You have already registered");
        newDoctor = doctor(_license,_name,_hospital);
        dMap[_license]=newDoctor;
        licenseExists[_license]=true;
    }
    
    function updateDoctor(uint256 _license,string memory _name,string memory _hospital) public {
        
        
        dMap[_license].name = _name;
        dMap[_license].hospital = _hospital;
    }
    
    
    

}
