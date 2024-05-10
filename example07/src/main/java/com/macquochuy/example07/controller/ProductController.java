package com.macquochuy.example07.controller;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.macquochuy.example07.entity.Product;
import com.macquochuy.example07.service.ProductService;
import java.util.List;

// import org.springframework.http.HttpHeaders;
// import org.springframework.http.MediaType;
// import org.springframework.web.multipart.MultipartFile;
// import org.springframework.core.io.ClassPathResource;
// import org.springframework.core.io.Resource;
// import java.io.File;
// import java.io.FileOutputStream;
// import java.io.IOException;
// import java.nio.file.Files;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@AllArgsConstructor
@RequestMapping("api/products")
public class ProductController {
    private ProductService productService;

    // Create Product REST API
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product Product) {
        Product savedProduct = productService.createProduct(Product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    // Get Product by id REST API
    // http://localhost:8080/api/Products/1

    @GetMapping("{id}")
    public ResponseEntity<Product> getProductById(@PathVariable("id") Long ProductId) {
        Product Product = productService.getProductById(ProductId);
        return new ResponseEntity<>(Product, HttpStatus.OK);
    }

    // Get All Products REST API
    // http://localhost:8080/api/Products
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> Products = productService.getAllProducts();
        return new ResponseEntity<>(Products, HttpStatus.OK);
    }

    // Update Product REST API
    @PutMapping("{id}")
    // http://localhost:8080/api/Products/1
    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long ProductId,
            @RequestBody Product Product) {
        Product.setId(ProductId);
        Product updatedProduct = productService.updateProduct(Product);
        return new ResponseEntity<>(updatedProduct, HttpStatus.OK);
    }

    // Delete Product REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Long ProductId) {
        productService.deleteProduct(ProductId);
        return new ResponseEntity<>("Product successfully deleted!", HttpStatus.OK);
    }

    // //Thêm hình ảnh
    
    // @PostMapping("/image")
    // public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file,
    //         @RequestParam("customName") String customName) {
    //     try {
    //         // Save the uploaded image to a database or a file system
    //         String uploadDir = "src/main/resources/static/dataImage"; // Set your desired directory path

    //         // Create the directory if it doesn't exist
    //         File directory = new File(uploadDir);
    //         if (!directory.exists()) {
    //             directory.mkdirs();
    //         }

    //         // Generate a unique filename for the uploaded image (you may need to modify
    //         // this logic)
    //         // String fileName = file.getOriginalFilename();

    //         String filePath = uploadDir + File.separator + customName + ".png";

    //         // Save the uploaded image to the specified directory
    //         try (FileOutputStream fos = new FileOutputStream(filePath)) {
    //             fos.write(file.getBytes());
    //         }
    //         return ResponseEntity.ok("Image uploaded successfully");
    //     } catch (Exception e) {
    //         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload image");
    //     }
    // }

    // @GetMapping("/image/{imageName}")
    // public ResponseEntity<byte[]> getImage(@PathVariable String imageName) throws IOException {
    //     // You should sanitize and validate the imageName parameter to prevent directory
    //     // traversal attacks.
    //     // In this example, it is assumed that imageName is just the name of the image
    //     // file.

    //     Resource resource = new ClassPathResource("static/dataImage/" + imageName);
    //     byte[] imageBytes = Files.readAllBytes(resource.getFile().toPath());

    //     HttpHeaders headers = new HttpHeaders();
    //     headers.setContentType(MediaType.IMAGE_JPEG); // Set the appropriate image media type

    //     return new ResponseEntity<>(imageBytes, headers, HttpStatus.OK);
    // }
}
