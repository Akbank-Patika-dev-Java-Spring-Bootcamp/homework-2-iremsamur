package com.akbankbootcamp.ETradeBackend.controller;

import com.akbankbootcamp.ETradeBackend.controller.contract.CommentControllerContract;
import com.akbankbootcamp.ETradeBackend.controller.contract.ProductControllerContract;
import com.akbankbootcamp.ETradeBackend.controller.contract.UserControllerContract;
import com.akbankbootcamp.ETradeBackend.dto.comment.CommentByProductDTO;
import com.akbankbootcamp.ETradeBackend.dto.comment.CommentByUserDTO;
import com.akbankbootcamp.ETradeBackend.dto.comment.CommentDTO;
import com.akbankbootcamp.ETradeBackend.dto.comment.CommentSaveRequestDTO;
import com.akbankbootcamp.ETradeBackend.general.RestResponse;
import com.akbankbootcamp.ETradeBackend.general.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comments")
public class CommentController {
    private final CommentControllerContract commentControllerContract;

    @Autowired
    public CommentController(CommentControllerContract commentControllerContract) {
        this.commentControllerContract = commentControllerContract;
    }

    @PostMapping
    public ResponseEntity<RestResponse<CommentDTO>> add(@RequestBody CommentSaveRequestDTO commentSaveRequest) {
        var commentDTO = commentControllerContract.add(commentSaveRequest);
        if(commentDTO.getId()!=null){
            return ResponseEntity.ok(RestResponse.success(commentDTO,"Yorum başarıyla eklendi."));
        }
        else{
            return ResponseEntity.ok(RestResponse.emptyError("Yorum kaydedilemedi!! Bir sorun oluştu!!"));
        }

    }
    @PutMapping("/{id}")
    public ResponseEntity<RestResponse<CommentDTO>> update(@RequestBody CommentSaveRequestDTO commentSaveRequestDTO,@PathVariable Long id) {
        var commentDTO = commentControllerContract.update(commentSaveRequestDTO,id);
        if(commentDTO.getId()!=null){
            return ResponseEntity.ok(RestResponse.success(commentDTO,"Yorum başarıyla güncellendi."));
        }
        else{
            return ResponseEntity.ok(RestResponse.emptyError("Yorum güncellenemedi!! Bir sorun oluştu!!"));
        }
    }

    @GetMapping
    public ResponseEntity<RestResponse<List<CommentDTO>>> findAll() {
        var commentDTOList = commentControllerContract.findAll();
        return ResponseEntity.ok(RestResponse.of(commentDTOList));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RestResponse<Object>> delete(@PathVariable Long id) {
        commentControllerContract.delete(id);
        return ResponseEntity.ok(RestResponse.emptySuccess("Yorum başarıyla silindi"));


    }
    @GetMapping("/{id}")
    public ResponseEntity<RestResponse<CommentDTO>> findById(@PathVariable Long id) {
        var commentDTO = commentControllerContract.getById(id);
        return ResponseEntity.ok(RestResponse.of(commentDTO));
    }
    //kullanıcıya göre o kullanıcının yaptığı yorumları getirir
    @GetMapping("/getByUser/{id}")
    public ResponseEntity<RestResponse<List<CommentByUserDTO>>> findByUserId(@PathVariable Long id) {
        var userDTO = commentControllerContract.findUserById(id);
        try {
            var commentDTO = commentControllerContract.findAllByUserId(id);
            return ResponseEntity.ok(RestResponse.of(commentDTO));
        } catch (BusinessException ex) {
            return ResponseEntity.ok(RestResponse.emptyError(userDTO.getName()+" "+userDTO.getSurname()+ex.getMessage()));
        }

    }
    //ürüne göre o ürüne yapılmış yorumları getirir
    @GetMapping("/getByProduct/{id}")
    public ResponseEntity<RestResponse<List<CommentByProductDTO>>> findByProductId(@PathVariable Long id) {
        var productDTO = commentControllerContract.findProductById(id);
        try {
            var commentDTO = commentControllerContract.findAllByProductId(id);
            return ResponseEntity.ok(RestResponse.of(commentDTO));
        } catch (BusinessException ex) {
            return ResponseEntity.ok(RestResponse.emptyError(productDTO.getName()+ex.getMessage()));
        }

    }


}
