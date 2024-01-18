package fa.training.fjb04.ims.service.impl;

import fa.training.fjb04.ims.repository.UserRepository;
import fa.training.fjb04.ims.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public List<String> getAllName () {
        return userRepository.getAllInterviewerName();
    };
}
