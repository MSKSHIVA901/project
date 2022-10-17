package com.bean;
import java.io.InputStream;

public class UploadBean {
	private String filename, content, enc, key,servername,fid,keyword1,keyword2,email;
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getKeyword1() {
		return keyword1;
	}

	public void setKeyword1(String keyword1) {
		this.keyword1 = keyword1;
	}

	public String getKeyword2() {
		return keyword2;
	}

	public void setKeyword2(String keyword2) {
		this.keyword2 = keyword2;
	}

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public String getServername() {
		return servername;
	}

	public void setServername(String servername) {
		this.servername = servername;
	}

	private InputStream photo1;

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getEnc() {
		return enc;
	}

	public void setEnc(String enc) {
		this.enc = enc;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public void setPhoto1(InputStream photo1) {
		// TODO Auto-generated method stub
		this.photo1 = photo1;
	}

	public InputStream getPhoto() {
		// TODO Auto-generated method stub
		return photo1;
	}

}