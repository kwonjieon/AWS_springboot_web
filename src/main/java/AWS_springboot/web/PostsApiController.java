package AWS_springboot.web;


import AWS_springboot.service.posts.PostsService;
import AWS_springboot.web.dto.PostsResponseDto;
import AWS_springboot.web.dto.PostsSaveRequestDto;
import AWS_springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        return postsService.save(requestDto);

    }
    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable("id") Long id,@RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id,requestDto);
    }
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable("id") Long id){//이름명시
        return postsService.findById(id);
    }
}
