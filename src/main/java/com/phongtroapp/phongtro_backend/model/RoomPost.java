package com.phongtroapp.phongtro_backend.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "advertisementpost")
public class RoomPost {
    @Id
   private String postId;
    @Column(name = "roomId")
   private String roomId;
   private Date createdAt;
   private int status;

   @PrePersist
    protected void onCreate(){
       this.createdAt= new Date();
       this.status=0;
   }
  public RoomPost(String postId, String roomId){
       this.postId= postId;
       this.roomId=roomId;
  }
  public RoomPost(){}
}
