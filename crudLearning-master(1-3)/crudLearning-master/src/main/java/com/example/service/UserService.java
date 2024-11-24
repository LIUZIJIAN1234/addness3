package com.example.service;

import com.alibaba.excel.EasyExcel;
import com.example.common.Result;
import com.example.dao.UserRepository;
import com.example.entity.User;
import com.example.utils.FileUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class UserService {

    @Resource
    private UserRepository userRepository;
    @Resource
    private FileUtils fileUtils;

    public void save(User user) {
        String now = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        user.setCreateTime(now);

        if (ObjectUtils.isNotEmpty(user.getFile())) {
            String url = fileUtils.uploadSingleFile(user.getFile());
            user.setImage(url);
        }
        userRepository.save(user);
    }

    public void saveCollect(User user) {
        userRepository.saveCollect(user);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Page<User> findPage(Integer pageNum, Integer pageSize, String name) {
        // 构建分页查询条件
        Sort sort = new Sort(Sort.Direction.DESC, "create_time");
        Pageable pageRequest = PageRequest.of(pageNum - 1, pageSize, sort);
        return userRepository.findByNameLike(name, pageRequest);
    }


    public Result<?> importExcel(MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();
        List<User> users = EasyExcel.read(inputStream, User.class, null).sheet().doReadSync();
        users.forEach(e->{
            e.setIsCollect(1);
        });
        userRepository.saveAll(users);
        return Result.success();
    }

    public void export(HttpServletResponse response) throws IOException {
        // 设置响应内容类型
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setCharacterEncoding("utf-8");

        String fileName = URLEncoder.encode("用户列表", "UTF-8") + ".xlsx";

        response.setHeader("Content-disposition", "attachment;filename=" + fileName);
        // 模拟数据
        List<User> list = userRepository.findAll();
        EasyExcel.write(response.getOutputStream(), User.class).sheet("用户列表").doWrite(list);
    }
}
