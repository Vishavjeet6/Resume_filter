import { Component, OnInit } from '@angular/core';
import {NgForm} from '@angular/forms';
import { FileService } from 'src/app/service/file.service';
import { Router } from '@angular/router';


@Component({
  selector: 'app-userhome',
  templateUrl: './userhome.component.html',
  styleUrls: ['./userhome.component.css']
})
export class UserhomeComponent implements OnInit {
  // filesToUpload: Array<File> = [];
  fileToUpload: File;
  msg='';

  constructor(private _fileService: FileService,
    private _router: Router) { }

  ngOnInit(): void {
  }

  fileChangeEvent(fileInput: any) {
    // this.filesToUpload = <Array<File>>fileInput.target.files;
    this.fileToUpload = fileInput.target.files[0];
}

  uploadPdf(){
    const formData: any = new FormData();
    // const files: Array<File> = this.filesToUpload;
    // console.log(files);
    // for(let i =0; i < files.length; i++){
    //   formData.append("file",files[i]);
    // }
    formData.append("file",this.fileToUpload);
    this._fileService.addFilesFromRemote(formData).subscribe(
      data =>{
        console.log(data);
        console.log("File Successfully Uploaded");
        this.msg = "File Successfully Uploded";
        alert(this.msg);
        this._router.navigate(['/home']);
      },
      error => {
        console.log("File Cannot be uploaded");
        console.log(error);
        this.msg = "File Cannot be uploaded"
        alert(this.msg);
      }
    )
  }
}
