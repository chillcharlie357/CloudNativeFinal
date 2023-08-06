package service;

import entity.MsgEntity;
import org.springframework.stereotype.Service;

@Service
public class MsgServiceImpl implements MsgService {
    @Override
    public MsgEntity msgEntity() {
        return new MsgEntity();
    }
}
