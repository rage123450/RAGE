enum class NetError {
    NET_OK(0),             //성공
    ERR_UNKNOWN,             //알 수 없는 에러입니다.
    ERR_CLIENT_STATE,             //유저 상태 오류입니다.
    ERR_CONNECT_00,             //버전이 맞지 않습니다. 패치 후 재접속 하세요.
    ERR_CONNECT_04,             //서버 수용 인원이 가득 찼습니다.
    ERR_CONNECT_05,             //게임서버 점검중입니다. 점검시간이 끝난후에 접속해주세요.
    ERR_VERIFY_00,             //동일서버간 이중 접속 시도입니다.
    ERR_VERIFY_01,             //타서버간 이중접속 시도입니다.
    ERR_VERIFY_02,             //서버 IP 검증 실패입니다.
    ERR_VERIFY_03,             //서버 UID 충돌입니다.
    ERR_VERIFY_04,             //유저가 존재하지 않습니다.
    ERR_VERIFY_05,             //삭제된 유저입니다.
    ERR_VERIFY_06,             //입력된 두 패스워드가 일치하지 않습니다.
    ERR_VERIFY_08,             //서버 작동 플래그 설정 실패입니다.
    ERR_VERIFY_10,             //NEXON 인증 실패입니다.
    ERR_VERIFY_11,             //차단된 계정입니다.
    ERR_VERIFY_12,             //운영자 이상 레벨만 요청 가능합니다.
    ERR_VERIFY_13,             //프록시 ID가 없습니다.
    ERR_VERIFY_14,             //허용되지 않은 IP 입니다.
    ERR_VERIFY_15,             //게임서버의 해당 채널 ID정보가 없습니다.
    ERR_VERIFY_16,             //ID의 길이가 이상합니다.
    ERR_NEW_ACCOUNT_02,             //트랜잭션 에러입니다.
    ERR_NEW_ACCOUNT_03,             //ID 길이가 잘못되었습니다.
    ERR_NEW_ACCOUNT_04,             //PASSWORD 길이가 잘못되었습니다.
    ERR_NEW_ACCOUNT_06,             //이름 길이가 잘못되었습니다.
    ERR_CREATE_UNIT_00,             //삭제된 유저가 캐릭터 생성을 시도하였습니다.
    ERR_CREATE_UNIT_01,             //캐릭터 닉네임이 이미 존재합니다.
    ERR_CREATE_UNIT_02,             //트랜잭션 에러입니다.
    ERR_CREATE_UNIT_03,             //캐릭터 데이터 로드 실패입니다.
    ERR_CREATE_UNIT_04,             //캐릭터 닉네임 길이가 잘못되었습니다.
    ERR_CREATE_UNIT_05,             //더 이상의 캐릭터를 생성할 수 없습니다.
    ERR_CREATE_UNIT_06,             //해당 닉네임은 일정 기간 동안 사용할 수 없습니다.
    ERR_CREATE_UNIT_07,             //넥슨 메신저용 CharacterSN을 DB에 생성하지 못했습니다.
    ERR_CREATE_UNIT_08,             //사용할 수 없는 닉네임입니다.
    ERR_CREATE_UNIT_09,             //캐릭터는 하루에 네번만 생성할 수 있습니다.
    ERR_SELECT_UNIT_00,             //선택한 캐릭터가 게임 서버에 없습니다.
    ERR_SELECT_UNIT_01,             //선택한 캐릭터의 클래스가 이상합니다.
    ERR_SELECT_UNIT_03,             //부활석 정보를 DB에서 받아오지 못했습니다.
    ERR_SELECT_UNIT_04,             //넥슨 메신저용 CharacterSN을 DB에서 받아오지 못했습니다.
    ERR_SELECT_UNIT_05,             //캐릭터 선택 과정에서 DB 오류가 발생하였습니다.
    ERR_SELECT_UNIT_06,             //닉네임을 변경해야 합니다.
    ERR_CHANNEL_00,             //레벨에 맞는 PVP채널을 찾지 못했습니다.
    ERR_CHANNEL_02,             //채널에서 삭제할 유저를 찾지 못했습니다.
    ERR_CHANNEL_04,             //채널 이동 실패하였습니다.
    ERR_CHANNEL_05,             //VP가 부족하여 입장할 수 없습니다.
    ERR_CHANNEL_06,             //광장 채널에 입장하지 못했습니다.
    ERR_CHANNEL_07,             //채널 입장하지 못했습니다.
    ERR_CHANNEL_09,             //진행중인 대회가 없습니다.
    ERR_ROOM_LIST_00,             //파티 리스트를 불러올 수 없습니다.
    ERR_ROOM_LIST_01,             //던전 게이트에서만 파티 리스트를 볼 수 있습니다.
    ERR_ROOM_LIST_02,             //해당 던전 게이트에서 볼 수 있는 파티리스트가 아닙니다.
    ERR_ROOM_LIST_03,             //3레벨부터 대전을 할 수 있습니다.
    ERR_ROOM_00,             //방 서버에 더 이상 방을 만들 수 없습니다.
    ERR_ROOM_01,             //해당 슬롯에서 유저를 발견할 수 없습니다.
    ERR_ROOM_02,             //해당 캐릭터가 있는 슬롯을 찾을 수 없습니다.
    ERR_ROOM_03,             //방이 꽉 찼습니다.
    ERR_ROOM_04,             //비밀 번호가 틀립니다.
    ERR_ROOM_06,             //선행던전을 클리어하지 않았습니다.
    ERR_ROOM_07,             //퀵조인 할 수 있는 방이 없습니다.
    ERR_ROOM_08,             //방장만 요청할 수 있습니다.
    ERR_ROOM_09,             //패킷이 허용되는 방 상태가 아닙니다.
    ERR_ROOM_10,             //준비 상태가 아닌 유저가 있습니다.
    ERR_ROOM_11,             //팀 인원수가 같지 않습니다.
    ERR_ROOM_12,             //한 명 이상 READY 해야 시작 할 수 있습니다.
    ERR_ROOM_13,             //로딩 상태를 변경하지 못했습니다.
    ERR_ROOM_14,             //방이 생성되었습니다.
    ERR_ROOM_15,             //방 정보가 변경되었습니다.
    ERR_ROOM_16,             //방이 삭제되었습니다.
    ERR_ROOM_17,             //방에서 유저를 검색하지 못했습니다.
    ERR_ROOM_18,             //난입 실패하였습니다.
    ERR_ROOM_19,             //난입 가능 방에서 나가지 못했습니다.
    ERR_ROOM_20,             //죽은 NPC UID가 잘못되었습니다.
    ERR_ROOM_21,             //이미 죽은 NPC입니다.
    ERR_ROOM_22,             //몬스터 데이터가 잘못되어 로딩 실패하였습니다.
    ERR_ROOM_23,             //대상 유저를 찾을 수 없습니다.
    ERR_ROOM_24,             //채팅 타입이 이상합니다.
    ERR_ROOM_26,             //자기 자신을 강퇴 시킬수 없습니다.
    ERR_ROOM_27,             //근성도가 부족합니다.
    ERR_ROOM_28,             //추가 스탯을 지원하지 않는 게임 타입입니다.
    ERR_ROOM_29,             //게임 종료중이라 난입할 수 없습니다.
    ERR_ROOM_30,             //방에 입장할 수 없습니다.
    ERR_ROOM_31,             //입장 중인 방을 알 수 없습니다.
    ERR_ROOM_32,             //거래 중에는 게임 준비를 할 수 없습니다.
    ERR_ROOM_33,             //게임 시작 중이라 난입할 수 없습니다. 잠시 후에 다시 시도해주세요.
    ERR_ROOM_34,             //게임 시작 아이템이 인벤토리에 없습니다.
    ERR_ROOM_35,             //권한이 없는 유저가 옵저버 방을 만들려고 시도했습니다.
    ERR_ROOM_36,             //잘못된 대전맵 정보입니다.
    ERR_ROOM_39,             //오프라인 대회 참여권을 가지고 있는 유저는 대회 채널을 이용하실 수 없습니다.
    ERR_ROOM_41,             //해당 던전을 플레이 하기 위한 아이템이 없습니다. 게임 시작 시 방에서 자동으로 이탈하게 됩니다.
    ERR_ROOM_43,             //대전 방에서만 초대 기능을 사용하실 수 있습니다.
    ERR_ROOM_44,             //초대하려는 상대가 대전방에 입장할 수 없는 상태입니다.
    ERR_ROOM_45,             //대전 채널 로비에 있는 유저만 초대할 수 있습니다.
    ERR_ROOM_46,             //파티에 속해 있어야 게임이 시작가능합니다.
    ERR_ROOM_47,             //킬 수 세팅이 이상합니다.
    ERR_ITEM_00,             //습득하려는 아이템이 없습니다.
    ERR_ITEM_01,             //다른 사람이 이미 습득하였습니다.
    ERR_ITEM_03,             //랜덤으로 아이템 주기가 실패하였습니다.
    ERR_ITEM_04,             //아이템 정보를 찾지 못했습니다.
    ERR_ITEM_05,             //아이템 ID가 잘못되었습니다.
    ERR_ITEM_06,             //아이템을 주지 못했습니다.
    ERR_ITEM_07,             //아이템을 수리하지 못했습니다.
    ERR_ITEM_08,             //퀵슬롯에 있는 아이템을 사용하지 못했습니다.
    ERR_ITEM_09,             //이벤트 던전에서는 퀵슬롯을 사용할 수 없습니다.
    ERR_ITEM_10,             //아이템을 획득하지 못했습니다.
    ERR_ITEM_11,             //임시 인벤토리의 아이템을 가져오지 못했습니다.
    ERR_ITEM_12,             //임시 인벤토리 아이템을 인벤토리에 넣을 공간이 부족합니다.
    ERR_ITEM_13,             //확성기 메시지 길이가 너무 깁니다.
    ERR_SLOT_01,             //팀을 변경하지 못했습니다.
    ERR_SLOT_02,             //슬롯 상태를 변경하지 못했습니다.
    ERR_SLOT_03,             //준비 상태를 변경하지 못했습니다.
    ERR_SLOT_04,             //슬롯에서 나가지 못했습니다.
    ERR_SLOT_05,             //강제 퇴장 시키지 못했습니다.
    ERR_SLOT_07,             //자신을 죽인 유저 데이터를 저장하지 못했습니다.
    ERR_SLOT_09,             //상태를 변경하지 못했습니다.
    NOT_LEAVE_ROOM_REASON_00,             //유저에 의한 퇴장입니다.
    NOT_LEAVE_ROOM_REASON_01,             //접속이 종료되었습니다.
    NOT_LEAVE_ROOM_REASON_02,             //강퇴로 인한 퇴장입니다.
    NOT_LEAVE_ROOM_REASON_04,             //레벨 업으로 인하여 해당 채널에 머무를 수 없습니다.
    NOT_LEAVE_ROOM_REASON_06,             //개인 거래가 완료되었습니다.
    NOT_LEAVE_ROOM_REASON_07,             //개인 거래 참가 실패입니다.
    NOT_LEAVE_ROOM_REASON_08,             //개인 거래 참가 지연으로 인한 퇴장입니다.
    NOT_LEAVE_ROOM_REASON_09,             //개인 거래가 취소되었습니다.
    NOT_LEAVE_ROOM_REASON_10,             //개인 거래 인원 수가 이상합니다.
    NOT_LEAVE_ROOM_REASON_11,             //개인 거래 중 오류가 발생하였습니다.
    NOT_LEAVE_ROOM_REASON_12,             //인벤토리 공간이 부족하거나 등록된 아이템 정보가 이상합니다.
    NOT_LEAVE_ROOM_REASON_14,             //근성도가 부족하여 던전을 진행 할 수 없습니다.
    NOT_LEAVE_ROOM_REASON_15,             //거래할 물품이 없어서 거래가 취소되었습니다.
    NOT_LEAVE_ROOM_REASON_16,             //거래가 취소되었습니다.
    NOT_LEAVE_ROOM_REASON_17,             //개인상점 물품등록 지연으로 상점이 종료되었습니다.
    NOT_LEAVE_ROOM_REASON_18,             //상점거래가 취소되었습니다.
    NOT_LEAVE_ROOM_REASON_19,             //개인 상점의 모든 물품이 판매 완료 되어 상점이 종료되었습니다.
    NOT_LEAVE_ROOM_REASON_20,             //방에서 퇴장하여 거래가 취소되었습니다.
    NOT_LEAVE_ROOM_REASON_21,             //개인 상점이 판매 종료 되었습니다.
    NOT_LEAVE_ROOM_REASON_23,             //클라이언트 크래쉬입니다.
    NOT_LEAVE_ROOM_REASON_24,             //대회 채널에 더 이상 머무를 수 없습니다.
    NOT_LEAVE_PARTY_REASON_01,             //대전 게임 진입으로 인한 파티 탈퇴입니다.
    NOT_LEAVE_PARTY_REASON_02,             //던전 게임 중단으로 인한 파티 탈퇴입니다.
    NOT_LEAVE_PARTY_REASON_03,             //마켓 진입으로 인한 파티 탈퇴입니다.
    NOT_LEAVE_PARTY_REASON_04,             //훈련소 진입으로 인한 파티 탈퇴입니다.
    ERR_CLIENT_QUIT_00,             //정상 종료입니다.
    ERR_CLIENT_QUIT_01,             //해킹 감지로 인한 종료입니다.
    ERR_CLIENT_QUIT_02,             //클라이언트 크래쉬로 인한 종료입니다.
    ERR_ADMIN_COMMAND_00,             //캐릭터 경험치 수정 실패입니다.
    ERR_ADMIN_COMMAND_01,             //요청한 캐릭터의 클래스를 DB에서 알아내지 못했습니다.
    ERR_ADMIN_COMMAND_03,             //권한 레벨이 잘못되었습니다.
    ERR_ADMIN_COMMAND_04,             //해당 유저가 없습니다.
    ERR_ADMIN_COMMAND_05,             //트랜잭션 에러입니다.
    ERR_ADMIN_COMMAND_06,             //해당 권한 레벨의 유저가 없음.
    ERR_ADMIN_COMMAND_07,             //운영자에 의해 접속이 종료되었습니다.
    ERR_ADMIN_COMMAND_08,             //이 명령어는 사내에서만 실행할 수 있습니다.
    ERR_ADMIN_COMMAND_09,             //이 명령어는 방에서 실행할 수 없습니다.
    ERR_BUY_ED_ITEM_05,             //아이템을 구입할 수 없습니다.
    ERR_SELL_ED_ITEM_05,             //아이템을 되팔 수 없습니다.
    ERR_QUEST_01,             //수행 중인 퀘스트입니다.
    ERR_QUEST_02,             //수행 중이지 않은 퀘스트를 지우려고 하였습니다.
    ERR_QUEST_03,             //존재하지 않는 퀘스트입니다.
    ERR_QUEST_04,             //완료한 퀘스트입니다.
    ERR_QUEST_05,             //이 캐릭터는 해당 퀘스트를 수행할 수 없는 캐릭터입니다.
    ERR_QUEST_06,             //이전의 필요한 퀘스트를 완료하지 않았습니다.
    ERR_QUEST_07,             //NPC에게 잘못된 퀘스트를 받았습니다.
    ERR_QUEST_08,             //퀘스트 템플릿이 존재하지 않습니다.
    ERR_QUEST_09,             //완료 조건이 만족되지 않았습니다.
    ERR_QUEST_10,             //퀘스트 관련 DB처리가 실패하였습니다.
    ERR_QUEST_11,             //퀘스트는 최대 10개까지만 수행이 가능합니다.
    ERR_QUEST_12,             //레벨이 낮아서 아직 퀘스트를 수락할 수 없습니다.
    ERR_QUEST_13,             //인벤토리 공간이 부족하여 퀘스트를 완료할 수 없습니다. 인벤토리를 먼저 정리해 주세요.
    ERR_QUEST_14,             //퀘스트 선택 보상 처리 중 오류가 발생하였습니다.
    ERR_QUEST_15,             //선택 보상 아이템 검색이 실패하였습니다.
    ERR_QUEST_17,             //이미 전직 퀘스트를 수행 중입니다.
    ERR_QUEST_18,             //전직 퀘스트 보상 처리 과정 중 오류가 발생하였습니다.
    ERR_QUEST_19,             //퀘스트 타입이 이상합니다.
    ERR_CHAT_01,             //채팅 입력 제한 시간보다 짧게 입력하였습니다.
    ERR_CHAT_02,             //자기 자신에게는 귓속말을 할 수 없습니다.
    ERR_CHAT_03,             //채팅 종류가 이상합니다.
    ERR_CHAT_04,             //현재 접속중이 아닙니다.
    ERR_ODBC_00,             //--/;/따옴표/쉼표/공백 등은 사용할 수 없습니다.
    ERR_REFRESH_01,             //유저 리스트 갱신시간보다 짧게 입력하였습니다.
    ERR_SEARCH_UNIT_01,             //유저정보 검색 제한시간이 지나지 않았습니다.
    ERR_SEARCH_UNIT_03,             //현재 접속 중이 아닙니다.
    ERR_SEARCH_UNIT_04,             //존재하는 닉네임이 아닙니다.
    ERR_SQUARE_01,             //광장 입장 실패입니다.
    ERR_SQUARE_02,             //광장 나가기 실패입니다.
    ERR_SKILL_00,             //이미 최고 레벨까지 배운 스킬입니다.
    ERR_SKILL_01,             //존재하지 않는 스킬입니다.
    ERR_SKILL_03,             //레벨이 낮아서 아직 스킬을 배울 수 없습니다.
    ERR_SKILL_04,             //스킬 포인트가 부족합니다.
    ERR_SKILL_05,             //습득 조건 아이템이 없습니다.
    ERR_SKILL_06,             //습득 조건 퀘스트를 클리어 하십시오.
    ERR_SKILL_07,             //선행 습득 스킬을 배우지 않았습니다.
    ERR_SKILL_08,             //이미 배운 스킬입니다.
    ERR_SKILL_09,             //변경할 스킬 슬롯 아이디가 잘못되었습니다.
    ERR_SKILL_10,             //배우지 않은 스킬을 등록하려고 하였습니다.
    ERR_SKILL_12,             //스킬을 초기화하지 못했습니다.
    ERR_SKILL_13,             //스킬 슬롯 B를 사용하실 수 없습니다.
    ERR_SKILL_14,             //스킬 슬롯 B 확장 중 DB오류가 발생하였습니다.
    ERR_SKILL_15,             //봉인 해제되지 않은 스킬은 배울 수 없습니다.
    ERR_SKILL_16,             //배울 수 없는 계층에 있는 스킬입니다.
    ERR_SKILL_17,             //스킬 포인트가 부족해서 스킬을 획득할 수 없습니다.
    ERR_SKILL_18,             //스킬 포인트가 부족해서 스킬을 획득할 수 없습니다.
    ERR_SKILL_19,             //존재하지 않는 스킬의 정보를 변경하려고 하였습니다.
    ERR_SKILL_20,             //스킬 레벨 정보가 이상합니다.
    ERR_SKILL_21,             //스킬 제한 레벨보다 높은 레벨로 설정하려고 하였습니다.
    ERR_SKILL_22,             //캐시 스킬포인트 기간 만료 처리가 실패하였습니다.
    ERR_SKILL_23,             //캐시 스킬포인트 등록이 실패하였습니다.
    ERR_SKILL_24,             //캐시 스킬포인트 정보 갱신이 실패하였습니다.
    ERR_SKILL_25,             //캐시 스킬포인트 정보 초기화가 실패하였습니다.
    ERR_SKILL_26,             //기본 스킬은 초기화 할 수 없습니다.
    ERR_PARTY_00,             //파티를 생성하지 못했습니다.
    ERR_PARTY_01,             //파티에서 탈퇴하지 못했습니다.
    ERR_PARTY_03,             //파티 정보가 잘못되었습니다.
    ERR_PARTY_07,             //초대할 수 없는 상태입니다.
    ERR_PARTY_09,             //소속된 파티가 없습니다.
    ERR_PARTY_12,             //이미 파티에 가입되어 있습니다.
    ERR_PARTY_13,             //대전에서는 파티를 생성할 수 없습니다.
    ERR_PARTY_14,             //대전에서는 파티에 입장할 수 없습니다.
    ERR_PARTY_15,             //파티 인원이 다 찼습니다.
    ERR_PARTY_16,             //파티에 가입하지 못했습니다.
    ERR_PARTY_17,             //삭제된 파티입니다.
    ERR_PARTY_18,             //파티 입장이 거절되었습니다.
    ERR_PARTY_19,             //파티 초대를 거부하였습니다.
    ERR_PARTY_20,             //준비 할 수 없는 장소입니다.
    ERR_PARTY_21,             //준비 상태 변경 실패입니다.
    ERR_PARTY_22,             //던전 선택이 잘못되었습니다.
    ERR_PARTY_23,             //게임 시작이 실패하였습니다.
    ERR_PARTY_25,             //게임 타입이 잘못되었습니다.
    ERR_PARTY_26,             //파티장이 아닙니다.
    ERR_PARTY_27,             //파티장을 변경하지 못했습니다.
    ERR_PARTY_28,             //파티 인원을 변경하지 못했습니다.
    ERR_PARTY_29,             //이 던전 게이트 소속 던전이 아닙니다.
    ERR_PARTY_30,             //공개 설정을 변경하지 못했습니다.
    ERR_PARTY_31,             //새로 임명될 파티장이 현재의 던전을 수행할 수 없습니다.
    ERR_PARTY_32,             //파티장은 레디 상태 변경을 할 수 없습니다.
    ERR_PARTY_33,             //채팅 상대자가 없습니다.
    ERR_PARTY_34,             //파티 리스트 요청 타입이 이상합니다.
    ERR_PARTY_35,             //레벨 제한 설정을 변경하지 못했습니다.
    ERR_PARTY_38,             //비공개 파티입니다.
    ERR_RESURRECT_00,             //부활석이 없습니다.
    ERR_RESURRECT_01,             //이미 부활 하였습니다.
    ERR_RESURRECT_02,             //부활 실패입니다.
    ERR_RESURRECT_03,             //이 던전에서는 부활석을 사용할 수 없습니다.
    ERR_COMMUNITY_OPT_01,             //없는 상태 값을 업데이트 하려고 하였습니다.
    ERR_COMMUNITY_OPT_02,             //커뮤니티 옵션 값을 받아오지 못했습니다.
    ERR_BLACKLIST_00,             //더이상 블랙리스트에 등록할 수 없습니다.
    ERR_BLACKLIST_01,             //이미 블랙리스트에 등록된 유저입니다.
    ERR_BLACKLIST_02,             //이미 블랙리스트에서 삭제된 유저입니다.
    ERR_BLACKLIST_03,             //존재하지 않는 유저입니다.
    ERR_BLACKLIST_04,             //블랙리스트에서 삭제하지 못했습니다.
    ERR_BLACKLIST_05,             //자기 자신을 블랙리스트에 등록할 수 없습니다.
    ERR_BLACKLIST_06,             //자기 자신은 블랙리스트에서 삭제할 수 없습니다.
    ERR_BLACKLIST_07,             //현재 접속 중인 유저만 블랙리스트에 등록할 수 있습니다.
    ERR_KNM_00,             //자신의 캐릭터를 추가할 수 없습니다.
    ERR_KNM_01,             //친구 추가 제한 시간이 지나지 않았습니다.
    ERR_KNM_02,             //캐릭터를 찾을 수 없습니다.
    ERR_KNM_03,             //내 캐릭터가 초대할 수 없는 상태입니다.
    ERR_KNM_04,             //상대방 캐릭터가 초대 받을 수 없는 상태입니다.
    ERR_KNM_05,             //상대방 캐릭터가 같이 할 수 없는 상태입니다.
    ERR_KNM_06,             //친구로 초대할 수 없습니다.
    ERR_TRADE_00,             //개인 거래를 생성하지 못했습니다.
    ERR_TRADE_01,             //개인 거래에서 이탈하지 못했습니다.
    ERR_TRADE_02,             //개인 거래 유저를 검색하지 못했습니다.
    ERR_TRADE_03,             //등록하려는 아이템 정보가 이상합니다.
    ERR_TRADE_04,             //등록하려는 ED 정보가 이상합니다.
    ERR_TRADE_05,             //거래 아이템이 존재하지 않습니다.
    ERR_TRADE_06,             //거래 ED가 부족합니다.
    ERR_TRADE_07,             //인벤토리에 있는 아이템만 등록할 수 있습니다.
    ERR_TRADE_09,             //인벤토리 공간이 부족합니다.
    ERR_TRADE_11,             //귀속 아이템은 거래할 수 없습니다.
    ERR_TRADE_12,             //거래채팅을 할 수 없는 장소입니다.
    ERR_TRADE_13,             //자기 자신과 거래할 수 없습니다.
    ERR_TRADE_14,             //내구도가 소모된 아이템은 거래할 수 없습니다. 아이템을 수리하고 거래해주세요.
    ERR_TRADE_15,             //이미 등록한 아이템입니다.
    ERR_TRADE_16,             //등록되지 않은 아이템을 삭제하려고 하였습니다.
    ERR_TRADE_17,             //거래 가능한 아이템 종류는 최대 10가지입니다.
    ERR_TRADE_18,             //거래가 성사되면 상대방의 ED 보유량이 최대치를 초과합니다. 거래 ED량을 줄여주세요.
    NOT_REQUEST_TRADE_REPLY_00,             //개인 거래 요청을 수락하였습니다.
    NOT_REQUEST_TRADE_REPLY_01,             //이미 다른 사람과 거래 중입니다.
    NOT_REQUEST_TRADE_REPLY_02,             //개인 거래 요청을 거절하였습니다.
    NOT_REQUEST_TRADE_REPLY_03,             //거래할 수 없는 상태입니다.
    NOT_REQUEST_TRADE_REPLY_04,             //서버 오류로 거래를 할 수 없습니다.
    ERR_DUNGEON_REQUIRE_ITEM_00,             //던전 입장에 필요한 아이템을 가지고 있지 않습니다.
    ERR_TC_01,             //훈련소 입장 조건을 만족하지 않습니다.
    ERR_TC_03,             //훈련소를 진행할 던전이 ID가 없습니다.
    ERR_TC_04,             //보상 처리 중 오류가 발생하였습니다.
    ERR_RANDOM_ITEM_00,             //선택한 아이템은 인벤토리에 없는 아이템입니다.
    ERR_RANDOM_ITEM_01,             //선택한 아이템은 큐브 아이템이 아닙니다.
    ERR_RANDOM_ITEM_02,             //이 캐릭터로는 사용할 수 없는 아이템입니다.
    ERR_RANDOM_ITEM_04,             //열쇠가 부족하여 큐브를 열 수 없습니다.
    ERR_RANDOM_ITEM_05,             //큐브를 열 수 없습니다.
    ERR_RANDOM_ITEM_06,             //아이템을 생성하지 못했습니다.
    ERR_RANDOM_ITEM_07,             //해당 큐브를 열기위한 인벤토리의 공간이 부족합니다.
    ERR_USER_REGISTRATION_00,             //이중 접속이 감지되었습니다.
    ERR_USER_REGISTRATION_01,             //유저 UID가 이상합니다.
    ERR_USER_REGISTRATION_02,             //유저 ID가 이상합니다.
    ERR_USER_REGISTRATION_03,             //캐릭터 UID가 이상합니다.
    ERR_USER_REGISTRATION_04,             //캐릭터 닉네임이 이상합니다.
    ERR_USER_REGISTRATION_05,             //게임 서버 UID가 이상합니다.
    ERR_USER_REGISTRATION_06,             //유저 정보 포인터가 이상합니다.
    ERR_USER_REGISTRATION_07,             //게임 서버 포인터가 이상합니다.
    ERR_USER_REGISTRATION_08,             //유저 UID 검색이 실패하였습니다.
    ERR_USER_REGISTRATION_09,             //메신져 고유 번호가 이상합니다.
    ERR_MANUFACTURE_00,             //아이템 제조를 할 수 없습니다.
    ERR_MANUFACTURE_02,             //주문서 아이템이 아닙니다.
    ERR_MANUFACTURE_03,             //ED가 부족하여 제조를 할 수 없습니다.
    ERR_MANUFACTURE_05,             //재료 아이템이 부족합니다.
    ERR_MANUFACTURE_10,             //제조를 하기 위해서는 해당 인벤토리에 빈칸이 1개 이상 있어야 합니다.
    ERR_MANUFACTURE_11,             //아이템을 생성하지 못했습니다.
    ERR_KNP_00,             //HackShield 인증이 실패하였습니다.
    ERR_KNP_01,             //HackShield 업데이트로 인하여 재시작해야 합니다.
    ERR_KNP_02,             //HackShield 인증이 실패하였습니다.
    ERR_NX_WEB_SERVICE_00,             //이미 사용한 쿠폰이거나 쿠폰 번호가 잘못 입력되었습니다. 쿠폰은 계정당 1회만 사용 가능합니다.
    ERR_NX_WEB_SERVICE_01,             //쿠폰 번호 30자를 입력해주세요.
    ERR_NX_COUPON_00,             //이미 사용된 쿠폰입니다.
    ERR_NX_COUPON_01,             //기간이 만료된 쿠폰입니다.
    ERR_NX_COUPON_02,             //쿠폰 번호가 올바르지 않습니다.
    ERR_NX_COUPON_03,             //이 쿠폰은 계정당 한 번만 사용 가능합니다.
    ERR_NX_COUPON_04,             //쿠폰을 사용하지 못했습니다.
    ERR_NX_COUPON_05,             //재구매 일수 미만입니다.
    ERR_NX_SHOP_00,             //아이템 리스트를 불러올 수 없습니다.
    ERR_NX_SHOP_01,             //가져오려는 아이템 정보가 이상합니다.
    ERR_NX_SHOP_02,             //인벤토리에 공간이 부족합니다.
    ERR_NX_SHOP_03,             //구매한 캐쉬 아이템을 가져오지 못했습니다.
    ERR_NX_SHOP_04,             //잔액 정보를 조회하지 못했습니다.
    ERR_NX_SHOP_05,             //회원 정보를 찾을 수 없습니다.
    ERR_NX_SHOP_06,             //차단된 계정입니다.
    ERR_NX_SHOP_07,             //다른 캐릭터 아이템은 인벤토리로 가져올 수 없습니다.
    ERR_NX_SHOP_08,             //동일한 기간제 아이템을 이미 가지고 있습니다.
    ERR_NX_SHOP_09,             //아이템을 가져오는 중입니다. 잠시만 기다려 주세요.
    ERR_STATISTICS_00,             //잘못된 프레임 평균 값입니다.
    ERR_RESTORE_NICK_NAME_00,             //해당 캐릭터가 존재하지 않습니다.
    ERR_RESTORE_NICK_NAME_01,             //닉네임 복구 대상이 아닙니다.
    ERR_RESTORE_NICK_NAME_02,             //동일한 닉네임이 이미 존재합니다.
    ERR_RESTORE_NICK_NAME_03,             //이 닉네임은 일정 기간 사용할 수 없습니다.
    ERR_RESTORE_NICK_NAME_04,             //닉네임 복구 작업이 실패하였습니다.
    ERR_RESTORE_NICK_NAME_05,             //유효하지 않은 닉네임입니다.
    ERR_RESTORE_NICK_NAME_06,             //닉네임 길이가 올바르지 않습니다.
    ERR_CHANGE_NICK_NAME_00,             //닉네임을 변경하지 못했습니다.
    ERR_PERSONAL_SHOP_00,             //개인 상점을 생성하지 못했습니다.
    ERR_PERSONAL_SHOP_01,             //광장에서만 상점을 생성할 수 있습니다.
    ERR_PERSONAL_SHOP_03,             //광장 유저 정보를 찾을 수 없어서 상점을 시작 할 수 없습니다.
    ERR_PERSONAL_SHOP_04,             //개인 상점 참여 인원이 많으므로 잠시 후에 이용해 주세요.
    ERR_PERSONAL_SHOP_05,             //개인 상점에 참여하지 못했습니다.
    ERR_PERSONAL_SHOP_06,             //판매 등록 하려는 아이템의 수량 정보가 잘못되었습니다.
    ERR_PERSONAL_SHOP_07,             //아이템이 이미 판매 등록된 상태입니다.
    ERR_PERSONAL_SHOP_08,             //개설자가 아닌데 판매 물품을 등록하려고 하였습니다.
    ERR_PERSONAL_SHOP_09,             //판매할 수 있는 물품 개수보다 등록된 아이템 개수가 많습니다.
    ERR_PERSONAL_SHOP_10,             //상점 개설 비용이 부족하므로 상점을 개설할 수 없습니다.
    ERR_PERSONAL_SHOP_11,             //상점 개설 준비가 아직 안되었습니다.
    ERR_PERSONAL_SHOP_12,             //상점에서 퇴장하지 못했습니다.
    ERR_PERSONAL_SHOP_14,             //구입하려는 아이템 수량이 판매 물품보다 많습니다.
    ERR_PERSONAL_SHOP_15,             //구입하려는 아이템이 없습니다.
    ERR_PERSONAL_SHOP_16,             //ED가 부족하여 물품을 구매할 수 없습니다.
    ERR_PERSONAL_SHOP_17,             //인벤토리에 공간이 없어서 구매할 수 없습니다.
    ERR_PERSONAL_SHOP_20,             //개설자를 찾지 못하여 거래하지 못했습니다.
    ERR_PERSONAL_SHOP_21,             //거래 중에는 상점을 열 수 없습니다.
    ERR_PERSONAL_SHOP_22,             //이미 개인 상점이 열려있습니다.
    ERR_PERSONAL_SHOP_23,             //최대 등록할 수 있는 ED량을 초과하였습니다.
    ERR_PERSONAL_SHOP_24,             //최대 구매할 수 있는 ED량을 초과하였습니다.
    ERR_PERSONAL_SHOP_25,             //구매하려는 아이템 정보가 이상합니다.
    ERR_RESOLVE_ITEM_00,             //선택한 아이템은 인벤토리에 없는 아이템입니다.
    ERR_RESOLVE_ITEM_01,             //분해할 수 있는 아이템이 아닙니다.
    ERR_RESOLVE_ITEM_02,             //분해 실패하였습니다. 다시 분해를 해주세요.
    ERR_RESOLVE_ITEM_03,             //장비와 악세사리만 분해가 가능합니다.
    ERR_RESOLVE_ITEM_04,             //분해를 할 수 없습니다.
    ERR_RESOLVE_ITEM_05,             //아이템 생성이 실패하였습니다.
    ERR_RESOLVE_ITEM_06,             //인벤토리 공간이 부족하여 분해를 할 수 없습니다.
    ERR_RESOLVE_ITEM_08,             //기간제 아이템은 분해할 수 없습니다.
    ERR_ENCHANT_ITEM_00,             //강화할 아이템이 인벤토리에 없습니다.
    ERR_ENCHANT_ITEM_01,             //아이템 정보가 존재하지 않습니다.
    ERR_ENCHANT_ITEM_02,             //무기나 방어구만 강화할 수 있습니다.
    ERR_ENCHANT_ITEM_03,             //강화할 수 있는 아이템이 아닙니다.
    ERR_ENCHANT_ITEM_04,             //더 이상 강화할 수 없습니다.
    ERR_ENCHANT_ITEM_05,             //강화석이 존재하지 않습니다.
    ERR_ENCHANT_ITEM_06,             //강화를 진행할 수 없습니다.
    ERR_ENCHANT_ITEM_07,             //강화에 필요한 ED가 부족합니다.
    ERR_ENCHANT_ITEM_08,             //장착중인 아이템은 강화할 수 없습니다.
    ERR_ENCHANT_ITEM_09,             //플루오르 스톤이 인벤토리에 없습니다.
    ERR_ENCHANT_ITEM_10,             //플루오르 스톤을 사용할 수 없습니다.
    ERR_ENCHANT_ITEM_11,             //강화 레벨 10부터는 강화시 플루오르 스톤을 사용할 수 없습니다.
    ERR_ENCHANT_ITEM_12,             //사용불가 아이템은 강화할 수 없습니다.
    ERR_ENCHANT_ITEM_13,             //강화 업데이트가 실패하였습니다.
    ERR_RESTORE_ITEM_00,             //복구할 아이템이 인벤토리에 없습니다.
    ERR_RESTORE_ITEM_01,             //아이템 정보가 존재하지 않습니다.
    ERR_RESTORE_ITEM_02,             //복구할 수 있는 아이템이 아닙니다.
    ERR_RESTORE_ITEM_03,             //사용불가 아이템만 복구가 가능합니다.
    ERR_RESTORE_ITEM_04,             //복구석이 부족하여 복구할 수 없습니다.
    ERR_RESTORE_ITEM_05,             //장착중인 아이템은 복구할 수 없습니다.
    ERR_RESTORE_ITEM_06,             //사용 불가 아이템에는 이용할 수 없는 기능입니다.
    ERR_ENCHANT_RESULT_00,             //강화 성공입니다.
    ERR_ENCHANT_RESULT_01,             //변화 없음입니다.
    ERR_ENCHANT_RESULT_02,             //1단계 하락입니다.
    ERR_ENCHANT_RESULT_03,             //강화 단계 초기화입니다.
    ERR_ENCHANT_RESULT_04,             //아이템 사용 불가입니다.
    ERR_SOCKET_ITEM_00,             //인벤토리에 없는 아이템입니다.
    ERR_SOCKET_ITEM_01,             //아이템 정보가 존재하지 않습니다.
    ERR_SOCKET_ITEM_02,             //수수료가 부족합니다.
    ERR_SOCKET_ITEM_03,             //무기나 방어구만 소켓이 존재합니다.
    ERR_SOCKET_ITEM_04,             //해당 장비에 대한 마법석 정보가 존재하지 않습니다.
    ERR_SOCKET_ITEM_05,             //인벤토리에 마법석이 없습니다.
    ERR_SOCKET_ITEM_06,             //소켓을 사용할 수 없습니다.
    ERR_SOCKET_ITEM_07,             //소켓에 이미 마법석이 꽂혀있습니다.
    ERR_SOCKET_ITEM_08,             //소켓에 이미 마법석이 제거되어 있습니다.
    ERR_SOCKET_ITEM_09,             //존재하지 않는 소켓 옵션입니다.
    ERR_RECOMMEND_USER_00,             //존재하지 않는 닉네임 입니다.
    ERR_RECOMMEND_USER_01,             //자기 자신은 추천할 수 없습니다.
    ERR_REWARD_TO_POST_00,             //보상을 받을 대상이 존재하지 않습니다.
    ERR_TUTORIAL_00,             //지우려는 사제 데이터가 DB에 없습니다.
    ERR_TUTORIAL_01,             //제자 리스트를 받아오지 못했습니다.
    ERR_TUTORIAL_02,             //레벨이 낮아 정보 제공을 할 수 없습니다.
    ERR_TUTORIAL_03,             //레벨이 낮아 제자를 받을 수 없습니다.
    ERR_TUTORIAL_04,             //제자는 3명까지 등록 가능합니다.
    ERR_TUTORIAL_05,             //이미 스승이 있습니다.
    ERR_TUTORIAL_06,             //이미 제자로 등록되어 있습니다.
    ERR_BUY_CASH_ITEM_00,             //구입하려는 상품 정보가 이상합니다.
    ERR_BUY_CASH_ITEM_01,             //상품을 구매할 수 없습니다.
    ERR_BUY_CASH_ITEM_02,             //중복 결제입니다.
    ERR_BUY_CASH_ITEM_03,             //상품 총 구매 수량을 초과하였습니다.
    ERR_BUY_CASH_ITEM_04,             //상품 구매 개수를 초과하였습니다.
    ERR_BUY_CASH_ITEM_05,             //이 상품을 아직은 다시 구매할 수 없습니다.
    ERR_BUY_CASH_ITEM_06,             //카트가 없습니다.
    ERR_BUY_CASH_ITEM_07,             //사용 제한된 게임입니다.
    ERR_BUY_CASH_ITEM_08,             //총 판매 수량 제한으로 인하여 구매할 수 없습니다.
    ERR_BUY_CASH_ITEM_09,             //주문 수량이 제한되었습니다.
    ERR_BUY_CASH_ITEM_10,             //이 상품을 다시 구매할 수 있는 시기가 아직 안되었습니다.
    ERR_BUY_CASH_ITEM_11,             //선물할 수 없는 상품입니다.
    ERR_BUY_CASH_ITEM_12,             //주문 수량이 제한되어 있습니다.
    ERR_BUY_CASH_ITEM_13,             //받는 사람이 이 상품을 다시 구매할 수 있는 시기가 아직 안되었습니다.
    ERR_BUY_CASH_ITEM_14,             //블록된 유저입니다.
    ERR_BUY_CASH_ITEM_15,             //회원 정보를 찾을 수 없습니다.
    ERR_BUY_CASH_ITEM_16,             //잔액이 부족합니다.
    ERR_BUY_CASH_ITEM_17,             //점검중입니다.
    ERR_BUY_CASH_ITEM_18,             //소지할 수 있는 최대 부활석 개수를 초과하게 됩니다.
    ERR_BUY_CASH_ITEM_19,             //인벤토리 슬롯 개수를 더 이상 확장할 수 없습니다.
    ERR_BUY_CASH_ITEM_20,             //자기 자신에게는 선물할 수 없습니다.
    ERR_BUY_CASH_ITEM_21,             //잘못된 비밀 번호를 입력하였습니다.
    ERR_BUY_CASH_ITEM_22,             //존재하지 않는 닉네임입니다.
    ERR_BUY_CASH_ITEM_23,             //체험 ID 유저에게는 선물할 수 없습니다.
    ERR_BUY_CASH_ITEM_24,             //선물할 수 있는 한도액이 초과되었습니다.
    ERR_BUY_CASH_ITEM_25,             //비밀 번호를 입력해주세요.
    ERR_BUY_CASH_ITEM_26,             //넥슨 계정 인증 실패입니다.
    ERR_BUY_CASH_ITEM_27,             //선물할 수 없는 상품입니다.
    ERR_BUY_CASH_ITEM_28,             //만 14세 미만은 이 기능을 사용할 수 없습니다.
    ERR_BUY_CASH_ITEM_30,             //캐릭터 슬롯 확장 상품을 구매할 수 없습니다. 슬롯 확장은 11개까지 가능합니다.
    ERR_BUY_CASH_ITEM_31,             //캐릭터 슬롯을 확장하지 못했습니다.
    ERR_BUY_CASH_ITEM_32,             //이미 해당 기능을 사용 중입니다.
    ERR_RESET_SKILL_00,             //존재하지 않는 스킬입니다.
    ERR_RESET_SKILL_01,             //스킬 초기화 아이템이 존재하지 않습니다.
    ERR_RESET_SKILL_02,             //스킬 초기화 아이템을 DB에서 삭제하지 못했습니다.
    ERR_RESET_SKILL_03,             //스킬 초기화 DB쿼리 결과 실패가 반환되었습니다.
    ERR_RESET_SKILL_04,             //초기화 할 수 없는 스킬입니다.
    ERR_RESET_SKILL_05,             //스킬 슬롯에 장착 중인 스킬은 초기화 할 수 없습니다.
    ERR_WISH_LIST_00,             //찜 리스트에 등록할 수 없는 상품입니다.
    ERR_WISH_LIST_02,             //찜 리스트에 더 이상 상품을 등록할 수 없습니다.
    ERR_GUEST_USER_00,             //체험 ID에서는 이용 하실 수 없는 기능입니다.
    ERR_GUEST_USER_01,             //체험 ID 유저는 추천인에 등록 할 수 없습니다.
    ERR_GUEST_USER_02,             //체험 ID를 이용하실 수 있는 레벨인 20렙이 되셨습니다. 계속 게임을 하시려면 넥슨ID로 전환해주세요.
    ERR_GUEST_USER_03,             //체험 ID 유저는 메신저 친구로 등록할 수 없습니다.
    ERR_HACK_USER_00,             //해킹 리스트에 등록된 유저가 아닙니다.
    ERR_HACK_USER_01,             //해킹 유저 동의 데이터를 디비 업데이트 하지 못했습니다.
    ERR_HACK_USER_02,             //해킹 신고 유저인데 동의를 하지 않았습니다.
    ERR_ATTRIB_ENCHANT_00,             //인벤토리에 존재하지 않는 아이템입니다.
    ERR_ATTRIB_ENCHANT_01,             //속성 강화를 할 수 없습니다.
    ERR_ATTRIB_ENCHANT_02,             //이미 속성 강화된 슬롯입니다.
    ERR_ATTRIB_ENCHANT_03,             //이미 속성 강화가 제거된 슬롯입니다.
    ERR_ATTRIB_ENCHANT_04,             //속성 강화를 위한 수수료가 부족합니다.
    ERR_ATTRIB_ENCHANT_05,             //속성 강화를 위한 엘의 조각이 부족합니다.
    ERR_ATTRIB_ENCHANT_06,             //아이템 정보가 이상합니다.
    ERR_ATTRIB_ENCHANT_07,             //무기와 방어구만 속성강화를 할 수 있습니다.
    ERR_IDENTIFY_00,             //선택된 아이템은 판별할 수 없는 아이템입니다.
    ERR_IDENTIFY_01,             //판별기가 부족하여 아이템을 감정할 수 없습니다.
    ERR_IDENTIFY_02,             //해당 아이템을 판별하기 위한 인벤토리 공간이 부족합니다.
    ERR_IDENTIFY_03,             //해당 아이템을 판별할 수 없습니다.
    ERR_IDENTIFY_04,             //아이템 생성 실패.
    ERR_POST_LETTER_00,             //우편함 정보를 얻을 수 없습니다.
    ERR_POST_LETTER_01,             //선택하신 아이템은 편지에 첨부할 수 없습니다.
    ERR_POST_LETTER_02,             //입력하신 ED는 편지에 첨부할 수 없습니다.
    ERR_POST_LETTER_03,             //편지를 전송하지 못했습니다.
    ERR_POST_LETTER_04,             //존재하지 않는 편지입니다.
    ERR_POST_LETTER_05,             //인벤토리에 여유공간이 없어서 첨부된 물품을 이동할 수 없습니다. 여유공간을 확보 하신 후 다시 시도 해 주시기 바랍니다.
    ERR_POST_LETTER_06,             //첨부 물품을 가져오지 못했습니다.
    ERR_POST_LETTER_07,             //존재하지 않는 아이템을 첨부하려고 하였습니다.
    ERR_POST_LETTER_08,             //완전히 수리된 아이템만 첨부할 수 있습니다.
    ERR_POST_LETTER_10,             //존재하는 닉네임이 아닙니다.
    ERR_POST_LETTER_11,             //동일한 캐릭터 간에는 편지를 보낼 수 없습니다.
    ERR_POST_LETTER_12,             //수수료 부족으로 편지를 발송할 수 없습니다.
    ERR_POST_LETTER_13,             //상대방의 우편함에 여유 공간이 없어 편지를 보낼 수 없습니다.
    ERR_POST_LETTER_14,             //이미 삭제된 편지를 선택하였습니다.
    ERR_POST_LETTER_15,             //상대방이 편지 받기를 거부하였습니다.
    ERR_POST_LETTER_16,             //귀속 아이템은 편지에 첨부할 수 없습니다.
    ERR_POST_LETTER_17,             //체험 ID 유저에게는 편지를 보내실 수 없습니다.
    ERR_POST_BLACK_LIST_00,             //존재하지 않는 닉네임입니다.
    ERR_POST_BLACK_LIST_01,             //이미 블랙리스트에 등록된 닉네임입니다.
    ERR_POST_BLACK_LIST_02,             //블랙리스트에 등록하지 못했습니다.
    ERR_POST_BLACK_LIST_03,             //이미 삭제된 닉네임입니다.
    ERR_POST_BLACK_LIST_04,             //블랙리스트에서 삭제하지 못했습니다.
    ERR_TITLE_00,             //보유하고 있는 칭호가 아닙니다.
    ERR_TITLE_01,             //이미 장착중인 칭호입니다.
    ERR_TITLE_02,             //사용 가능한 기간이 지난 칭호입니다.
    ERR_TITLE_03,             //존재하지 않는 칭호입니다.
    ERR_TITLE_04,             //칭호를 획득하지 못했습니다.
    ERR_TITLE_05,             //이미 보유 중인 칭호입니다.
    ERR_USE_ITEM_IN_INVENTORY_00,             //아이템을 사용할 수 없습니다.
    ERR_USE_ITEM_IN_INVENTORY_01,             //존재하지 않는 아이템입니다.
    ERR_USE_ITEM_IN_INVENTORY_02,             //캐릭터 레벨이 부족하여 아이템을 사용할 수 없습니다.
    ERR_USE_ITEM_IN_INVENTORY_03,             //인벤토리에서 사용 불가능한 아이템입니다.
    ERR_ATTACH_ITEM_00,             //인벤토리에 없는 아이템 입니다.
    ERR_ATTACH_ITEM_01,             //부여 아이템이 아닙니다.
    ERR_ATTACH_ITEM_02,             //부여가 가능한 아이템이 아닙니다.
    ERR_ATTACH_ITEM_03,             //강화 레벨 부여중 업데이트가 실패하였습니다.
    ERR_ITEM_EXCHANGE_00,             //아이템을 교환할 수 없습니다.
    ERR_ITEM_EXCHANGE_01,             //인벤토리에 없는 아이템 입니다.
    ERR_ITEM_EXCHANGE_02,             //이 아이템은 교환대상이 아닙니다.
    ERR_ITEM_EXCHANGE_04,             //교환 아이템 생성되지 않았습니다.
    NOT_LEAVE_FIELD_REASON_00,             //다른 필드로 이동하기 위한 이탈입니다.
    NOT_LEAVE_FIELD_REASON_01,             //방으로 입장하기 위한 이탈입니다.
    NOT_LEAVE_FIELD_REASON_02,             //시스템에서 유저를 이탈 처리하였습니다.
    ERR_FIELD_00,             //마을에 입장할 수 없습니다.
    ERR_FIELD_01,             //마을에서 나가지 못했습니다.
    ERR_FIELD_04,             //유저 리스트를 받아올 수 없습니다.
    ERR_FIELD_05,             //레벨이 낮아 마을에 입장할 수 없습니다.
    ERR_FIELD_06,             //마을에 입장하기 위한 던전을 클리어하지 않았습니다.
    ERR_CHANNEL_CHANGE_01,             //존재하지 않는 채널입니다.
    ERR_CHANNEL_CHANGE_03,             //채널 이동 성공으로 인한 접속 종료입니다.
    ERR_CHANNEL_CHANGE_05,             //채널이동을 위한 유저 등록이 실패하였습니다.
    ERR_CHANNEL_CHANGE_06,             //채널이동을 위한 유저 등록이 되어 있지 않습니다.
    ERR_CHANNEL_CHANGE_07,             //이동하려는 채널과 현재 채널이 같습니다.
    ERR_CHANNEL_CHANGE_08,             //수용 인원이 가득 차서 이동 할 수 없습니다.
    ERR_CHANNEL_CHANGE_09,             //마을 또는 필드에서만 채널 이동 기능을 이용하실 수 있습니다.
    ERR_CHANNEL_CHANGE_10,             //잠시 후에 채널 이동을 이용해주시기 바랍니다.
    ERR_GM_CHAR_DENY_00,             //GM 캐릭터는 사용할 수 없는 기능입니다.
    ERR_UPDATE_FRIEND_00,             //캐릭터가 선택되지 않았습니다.
    ERR_UPDATE_FRIEND_01,             //친구가 접속 중이 아닙니다.
    ERR_WRONG_STATE_00,             //잘못된 상태입니다.
    ERR_TIME_DROP_EVENT_00,             //이벤트로 드롭된 아이템을 DB업데이트하지 못했습니다.
    ERR_TIME_DROP_EVENT_01,             //이미 시간 이벤트 보상을 받았습니다.
    ERR_MESSENGER_00,             //이미 친구로 등록되어있는 캐릭터입니다.
    ERR_MESSENGER_01,             //친구 캐릭터의 상태가 올바르지 않습니다.
    ERR_MESSENGER_02,             //나를 친구로 초대한 캐릭터가 아닙니다.
    ERR_MESSENGER_03,             //이 캐릭터는 친구가 아닙니다.
    ERR_MESSENGER_04,             //그룹이 존재하지 않습니다.
    ERR_MESSENGER_05,             //메세지의 길이가 너무 깁니다.
    ERR_MESSENGER_06,             //현재 그룹과 이동시키려고 하는 그룹이 같습니다.
    ERR_MESSENGER_07,             //그룹을 더 이상 생성할 수 없습니다.
    ERR_MESSENGER_08,             //동일한 그룹이 이미 있습니다.
    ERR_MESSENGER_09,             //동일한 그룹 이름입니다.
    ERR_TUTORIAL_07,             //제자가 7일동안 접속을 하지 않아 사제관계가 종료 되었습니다.
    ERR_TUTORIAL_08,             //제자가 레벨업을 완료하여 사제관계가 종료 되었습니다.
    ERR_TUTORIAL_09,             //캐릭터가 삭제되어 사제관계가 종료 되었습니다.
    ERR_TUTORIAL_10,             //유저에 의해 사제관계가 종료되었습니다.
    ERR_TUTORIAL_11,             //사제관계 종료를 실패하였습니다.
    ERR_MESSENGER_10,             //친구 기능 관련 DB 작업 오류입니다.
    ERR_MESSENGER_11,             //그룹 이름이 너무 깁니다.
    ERR_MESSENGER_12,             //친구 리스트가 가득 차서 친구로 초대할 수 없습니다.
    ERR_MESSENGER_13,             //같은 계정의 캐릭터에게는 친구 초대를 할 수 없습니다.
    ERR_MESSENGER_14,             //상대방의 친구 리스트가 가득 차서 친구로 초대할 수 없습니다.
    ERR_MESSENGER_15,             //상대방이 친구 초대를 거부한 상태입니다.
    ERR_ODBC_01,             //쿼리 호출 실패입니다.
    ERR_ROOM_37,             //대회채널에서는 난입할 수 없습니다.
    ERR_ROOM_38,             //대회기간중에는 방에 인원이 가득차야만 게임이 시작 가능합니다.
    ERR_POST_LETTER_18,             //제목의 길이가 너무 깁니다.
    ERR_POST_LETTER_19,             //편지 내용의 길이가 너무 깁니다.
    ERR_PARTY_39,             //초대한 유저는 현재의 던전을 수행할 수 없습니다.
    ERR_USE_ITEM_IN_INVENTORY_04,             //이미 봉인이 해제된 스킬입니다.
    ERR_SKILL_27,             //스킬 봉인 해제를 실패하였습니다.
    ERR_BUY_CASH_ITEM_33,             //이 상품을 구매하실 수 없는 캐릭터 직업입니다.
    ERR_BUY_CASH_ITEM_34,             //이미 봉인이 해제된 스킬의 상품입니다.
    ERR_BUY_CASH_ITEM_35,             //선택하신 상품과 같은 기능의 아이템이 인벤토리에 있어 상품을 구매하실 수 없습니다.
    ERR_GUEST_USER_04,             //체험 ID 유저는 헤니르 시공 던전 파티에 초대할 수 없습니다.
    ERR_VERIFY_17,             //인증 방식이 맞지 않습니다.
    ERR_BANK_00,             //은행에 보관된 아이템은 분해할 수 없습니다.
    ERR_BANK_01,             //은행에 보관된 아이템은 소켓을 추가 할 수 없습니다.
    ERR_BANK_02,             //은행에서는 사용할 수 없는 기능입니다.
    ERR_BUY_CASH_ITEM_36,             //은행 슬롯 갯수를 더이상 확장할 수 없습니다.
    ERR_BUY_CASH_ITEM_37,             //은행 회원권은 1개이상 구매할 수 없습니다.
    ERR_BUY_CASH_ITEM_38,             //구매할 수 없는 은행 회원권 입니다.
    ERR_BUY_CASH_ITEM_39,             //인벤토리에 루리엘 신용보증서가 있으면 플래티넘 회원권 구매를 할 수 없습니다. 루리엘 신용보증서를 사용해주세요.
    ERR_VERIFY_18,             //패스워드가 존재하지 않습니다.
    ERR_VERIFY_19,             //패스워드 갱신을 할 수 없습니다.
    ERR_VERIFY_20,             //아이디 또는 패스워드가 올바르지 않습니다.
    ERR_VERIFY_21,             //인증 과정에서 시스템 오류가 발생하였습니다.
    ERR_SEAL_ITEM_00,             //존재하지 않는 아이템입니다.
    ERR_SEAL_ITEM_01,             //아이템 정보를 얻을 수 없습니다.
    ERR_SEAL_ITEM_02,             //봉인할 수 없는 아이템 종류입니다.
    ERR_SEAL_ITEM_03,             //장착중인 아이템은 봉인할 수 없습니다.
    ERR_SEAL_ITEM_04,             //이미 봉인된 아이템 입니다.
    ERR_SEAL_ITEM_05,             //수리되지 않은 아이템은 봉인할 수 없습니다.
    ERR_SEAL_ITEM_06,             //기간제 아이템은 봉인할 수 없습니다.
    ERR_SEAL_ITEM_07,             //파괴된 아이템은 봉인할 수 없습니다.
    ERR_SEAL_ITEM_08,             //거래가능 아이템은 봉인할 수 없습니다.
    ERR_SEAL_ITEM_09,             //봉인 가능한 횟수가 남지 않아 봉인할 수 없습니다.
    ERR_SEAL_ITEM_10,             //선택한 봉인주문서 정보가 이상합니다.
    ERR_SEAL_ITEM_11,             //봉인을 실패하였습니다.
    ERR_SEAL_ITEM_12,             //봉인 주문서가 부족하여 봉인할 수 없습니다.
    ERR_SEAL_ITEM_13,             //장착중인 아이템은 봉인해제를 할 수 없습니다.
    ERR_SEAL_ITEM_14,             //이미 봉인해제된 아이템 입니다.
    ERR_SEAL_ITEM_15,             //봉인해제를 실패하였습니다.
    ERR_SEAL_ITEM_16,             //봉인정보 DB업데이트 실패입니다.
    ERR_ENCHANT_ITEM_14,             //봉인된 아이템은 강화할 수 없습니다.
    ERR_GASH_00,             //캐쉬 포인트 조회 중에 시스템 에러가 발생하였습니다.
    ERR_GASH_01,             //이 계정은 활동이 제한된 계정입니다.
    ERR_GASH_02,             //계정이 존재하지 않습니다.
    ERR_GASH_03,             //계정이 올바르지 않습니다.
    ERR_GASH_04,             //쿠폰 번호가 올바르지 않습니다.
    ERR_GASH_05,             //이미 사용된 쿠폰입니다.
    ERR_GASH_06,             //이 종류의 쿠폰은 한 번만 사용할 수 있습니다.
    ERR_GASH_07,             //사용 기한이 지난 쿠폰입니다.
    ERR_GASH_08,             //쿠폰 사용 중에 시스템 오류가 발생하였습니다.
    ERR_GASH_09,             //포인트가 부족합니다.
    ERR_GASH_10,             //아이템 구입 중에 시스템 오류가 발생하였습니다.
    ERR_BUY_CASH_ITEM_40,             //15 레벨 이상 부터 구매가 가능합니다.
    ERR_GUILD_00,             //이미 가입한 길드가 존재합니다.
    ERR_GUILD_01,             //이미 존재 하는 길드 이름입니다.
    ERR_GUILD_02,             //길드 창단 아이템이 인벤토리에 없습니다.
    ERR_GUILD_03,             //길드 창단 아이템 정보가 이상합니다.
    ERR_GUILD_04,             //길드 창단에 실패하였습니다.
    ERR_GUILD_05,             //길드 마스터 등록에 실패하였습니다.
    ERR_GUILD_06,             //길드 정보를 찾을 수 없습니다.
    ERR_GUILD_07,             //길드 초대를 할 수 없습니다.
    ERR_GUILD_08,             //현재 오프라인인 유저 입니다.
    ERR_GUILD_09,             //체험ID 유저는 길드에 초대할 수 없습니다.
    ERR_GUILD_10,             //이미 길드 초대한 유저입니다.
    ERR_GUILD_11,             //다른 길드에서 이미 초대한 유저입니다.
    ERR_GUILD_12,             //길드 초대를 할 수 있는 권한이 없습니다.
    ERR_GUILD_13,             //길드 인원을 더 이상 늘릴 수 없습니다. 길드 인원 확장을 위해서는 '길드 인원 확장 아이템'이 필요합니다.
    ERR_GUILD_14,             //초대하려는 유저는 이미 길드멤버입니다.
    ERR_GUILD_15,             //이미 길드에 가입되어있는 유저입니다.
    ERR_GUILD_16,             //길드 유저 리스트를 얻을 수 없습니다.
    ERR_GASH_11,             //쿠폰으로 획득하려는 아이템 정보가 올바르지 않습니다.
    ERR_GUILD_17,             //유저가 길드 초대를 거부한 상태입니다.
    ERR_GUILD_18,             //길드 가입 실패.
    ERR_GUILD_19,             //길드에 소속되어있지 않습니다.
    ERR_GUILD_20,             //길드원 등급변경 권한이 없습니다.
    ERR_GUILD_21,             //길드원 등급변경에 실패하였습니다.
    ERR_GUILD_22,             //길드마스터와 길드관리자만 길드메시지의 변경이 가능합니다.
    ERR_GUILD_23,             //길드 메시지 변경에 실패하였습니다.
    ERR_GUILD_24,             //길드원 강퇴 권한이 없습니다.
    ERR_GUILD_25,             //길드 마스터는 길드에서 탈퇴 할 수 없습니다.
    ERR_GUILD_26,             //길드 탈퇴를 실패하였습니다.
    ERR_GUILD_27,             //길드원 인사말 글자 길이 제한.
    ERR_GUILD_28,             //해당 길드원 인사말 변경에 대한 권한이 없습니다.
    ERR_GUILD_29,             //길드원 인사말 변경을 실패하였습니다.
    ERR_GUILD_30,             //길드마스터만 길드 해체 기능을 사용할 수 있습니다.
    ERR_GUILD_31,             //길드원이 남아 있으므로 길드 해체가 불가능합니다.
    ERR_GUILD_32,             //길드 해체를 실패하였습니다.
    ERR_GUILD_33,             //이미 변경된 등급입니다.
    ERR_GUILD_34,             //더 이상 길드 관리자를 임명 할 수 없습니다.\n새로운 길드 관리자를 임명 하려면\n현재 길드 관리자 등급을 조정해야 합니다.
    ERR_GUILD_35,             //길드마스터는 캐릭터 삭제를 할 수 없습니다. 길드마스터 등급을 다른 길드원에게 위임하세요.
    ERR_GUILD_36,             //자기 자신의 등급은 변경할 수 없습니다.
    ERR_GUILD_37,             //이미 길드에 소속 되어 있어 길드 창단 허가서를 구매할 수 없습니다.
    ERR_GUILD_38,             //인벤토리에 길드 창단 허가서가 존재합니다.
    ERR_GUILD_39,             //길드 인원 확장을 실패하였습니다.
    ERR_GUILD_40,             //길드 마스터와 길드 관리자만 길드 인원 확장권을 사용할 수 있습니다.
    ERR_GUILD_41,             //길드 인원을 더 이상 늘릴 수 없습니다.
    ERR_ITEM_14,             //거래중인 상태에서는 해당 기능을 이용할 수 없습니다.
    ERR_USE_ITEM_IN_INVENTORY_05,             //이동 할수없는 지역입니다.
    ERR_GUILD_42,             //이 길드 이름은 7일간 사용할 수 없습니다.
    ERR_GUILD_43,             //획득 가능한 최대 길드 경험치 입니다.
    ERR_GUILD_44,             //이 아이템을 구입하기 위해서는 관련 퀘스트를 수행 해야 합니다.
    ERR_GUILD_45,             //길드 이름의 길이가 너무 깁니다.
    ERR_ATTRIB_ENCHANT_08,             //속성 제거를 위한 수수료가 부족합니다.
    ERR_BUY_CASH_ITEM_41,             //35 레벨 이상 부터 구매가 가능합니다.
    ERR_GASH_12,             //게임을 종료하고 빈펀 계정으로 업그레이드 하시기 바랍니다. 빈펀 사이트는 tw.beanfun.gamania.com 입니다.
    ERR_GASH_13,             //이 계정은 이미 빈펀 계정으로 업그레이드 된 계정입니다. 빈펀 프로그램으로 접속해주세요.
    ERR_GASH_14,             //더 이상 아이템을 구입할 수 없습니다. 임시 보관함에 있는 아이템을 인벤토리로 가져오세요.
    ERR_GUILD_SKILL_00,             //길드 마스터 등급만 GSP를 투자할 수 있습니다.
    ERR_GUILD_SKILL_01,             //이미 최고 레벨까지 배운 길드스킬입니다.
    ERR_GUILD_SKILL_02,             //해당 길드 스킬 정보가 존재하지 않습니다.
    ERR_GUILD_SKILL_03,             //선행 길드스킬을 아직 최고레벨까지 배우지 못했습니다.
    ERR_GUILD_SKILL_04,             //충분한 GSP를 투자하지 않았습니다.
    ERR_GUILD_SKILL_05,             //GSP가 부족합니다.
    ERR_GUILD_SKILL_06,             //길드 스킬 배우기가 실패하였습니다.
    ERR_GUILD_SKILL_07,             //길드 마스터 등급만 길드 스킬을 되돌릴 수 있습니다.
    ERR_GUILD_SKILL_08,             //망각의 피리 아이템이 인벤토리에 없습니다.
    ERR_GUILD_SKILL_09,             //길드 스킬을 되돌릴 수 없습니다.
    ERR_GUILD_SKILL_10,             //길드 스킬 되돌리기가 실패하였습니다.
    ERR_GUILD_SKILL_11,             //길드 마스터 등급만 길드 스킬 초기화를 할 수 있습니다.
    ERR_GUILD_SKILL_12,             //망각의 뿔피리 아이템이 인벤토리에 없습니다.
    ERR_GUILD_SKILL_13,             //길드 스킬 초기화를 할 수 없습니다.
    ERR_GUILD_SKILL_14,             //길드 스킬 초기화를 실패하였습니다.
    ERR_GUILD_SKILL_15,             //길드 마스터 등급만 사용 가능 합니다.
    ERR_GUILD_SKILL_16,             //기간제 길드 스킬 포인트 획득 실패하였습니다.
    ERR_GUILD_SKILL_17,             //이미 그노시스의 대축복 아이템을 사용 중입니다.
    ERR_CUMULATIVE_TIME_EVENT_00,             //아직 이벤트 보상을 받을 수 없습니다.
    ERR_CUMULATIVE_TIME_EVENT_01,             //인벤토리 공간이 부족하여 이벤트 보상을 받을 수 없습니다.
    ERR_CUMULATIVE_TIME_EVENT_02,             //이벤트 보상 받기가 실패하였습니다.
    ERR_DUNGEON_ITEM_00,             //아이템 모드가 아닙니다.
    ERR_DUNGEON_ITEM_01,             //드롭된 아이템이 아직 남아있습니다.
    ERR_DUNGEON_ITEM_02,             //대전 드롭아이템 얻어오기 실패.
    ERR_CREATE_UNIT_10,             //케릭터 카드 사용 후 생성 가능한 클래스입니다.
    ERR_GASH_15,             //본 계정은 이벤트에 참여할 수 없습니다.
    ERR_GUILD_BOARD_00,             //길드 마스터 또는 길드 관리자만 이용할 수 있는 기능입니다.
    ERR_PC_BANG_00,             //PC방 전용 아이템은 이용할 수 없는 기능입니다.
    ERR_GUILD_BOARD_01,             //길드 광고가 존재하지 않습니다.
    ERR_GUILD_BOARD_02,             //글자 길이가 너무 깁니다.
    ERR_GUILD_BOARD_03,             //잘못된 광고 등록 기간입니다.
    ERR_GUILD_BOARD_04,             //광고 등록 비용이 부족하므로 광고를 등록 할 수 없습니다.
    ERR_GUILD_BOARD_05,             //이미 등록한 광고가 있습니다.
    ERR_GUILD_BOARD_06,             //길드 광고 등록을 실패하였습니다.
    ERR_GUILD_BOARD_07,             //가입 신청자가 너무 많아서 가입 신청을 할 수 없습니다.
    ERR_GUILD_BOARD_08,             //길드 가입 신청을 실패하였습니다.
    ERR_GUILD_BOARD_09,             //이미 가입 신청이 되어 있습니다.
    ERR_GUILD_BOARD_10,             //가입 신청 정보가 존재하지 않습니다.
    ERR_GUILD_BOARD_11,             //길드 가입 수락을 실패하였습니다.
    ERR_GUILD_BOARD_12,             //길드 가입 신청 삭제를 실패하였습니다.
    ERR_GUILD_BOARD_13,             //기간이 다된 광고에는 가입 신청을 할 수 없습니다.
    ERR_GUILD_BOARD_14,             //길드 가입 신청 리스트를 볼수 있는 권한이 없습니다.
    ERR_GASH_16,             //자물쇠를 열지 않았습니다.
    ERR_GASH_17,             //이 게임 계정은 정지 당했습니다.
    ERR_QUEST_16,             //PC방 전용 퀘스트는 PC방에서만 수락할 수 있습니다.
    ERR_QUEST_20,             //PC방 전용 퀘스트는 PC방에서만 완료할 수 있습니다.
    NOT_LEAVE_ROOM_REASON_25,             //해킹 감지로 인한 방 이탈 입니다.
    ERR_GUILD_BOARD_15,             //길드 초대 거부 옵션이 켜져있어서 가입 신청을 할 수 없습니다.
    ERR_GUILD_BOARD_16,             //길드 가입 신청자가 많아 더 이상 가입 신청을 할 수 없습니다.
    ERR_QUEST_21,             //현재 진행중인 이벤트 퀘스트가 아닙니다.
    ERR_BUY_CASH_ITEM_42,             //해당 아이템의 구매 한도가 초과되었습니다.
    ERR_BUY_CASH_ITEM_43,             //넥슨캐시 사용이 불가능하도록 설정돼 있습니다. 넥슨포털 내정보의 넥슨캐시 보안설정 메뉴에서 설정을 변경해주세요.
    ERR_WEB_POINT_EVENT_00,             //이미 오늘 출석 체크는 완료된 상태 입니다.
    ERR_WEB_POINT_EVENT_01,             //웹 포인트 증가 DB쿼리 호출 실패.
    ERR_WEB_POINT_EVENT_02,             //출석 체크 실패.
    NOT_LEAVE_PARTY_REASON_05,             //중복 파티 가입으로 인한 파티 이탈 처리.
    ERR_PARTY_40,             //파티 가입 대기중인 상태입니다.
    ERR_PERSONAL_SHOP_28,             //아이템 리스트 삭제.
    ERR_PERSONAL_SHOP_26,             //아이템 리스트 추가.
    ERR_PERSONAL_SHOP_27,             //아이템 리스트 수정.
    ERR_PERSONAL_SHOP_29,             //카테고리 선택이 잘못 되었습니다.
    ERR_PERSONAL_SHOP_30,             //검색하려는 아이템 정보가 없습니다.
    ERR_PARTY_41,             //초대 대상자의 근성도가 부족합니다.
    ERR_PERSONAL_SHOP_31,             //잠시후에 검색을 시도해 주세요.
    ERR_PERSONAL_SHOP_32,             //판매종료된 상점입니다.
    ERR_BUY_CASH_ITEM_44,             //구매 불가능한 상태의 사용자 입니다.
    ERR_SIM_ROOM_00,             //방 생성에 실패했습니다.
    ERR_SKILL_NOTE_00,             //존재하지 않는 아이템입니다.
    ERR_SKILL_NOTE_01,             //존재 하지 않는 페이지입니다.
    ERR_SKILL_NOTE_02,             //이미 등록되어 있는 메모입니다.
    ERR_SKILL_NOTE_03,             //메모 등록을 실패 하였습니다.
    ERR_SKILL_NOTE_04,             //기술의 노트를 보유하고 있지 않습니다.
    ERR_SKILL_NOTE_05,             //기술의 노트 페이지 확장 실패.
    ERR_SKILL_NOTE_06,             //이미 기술의 노트를 보유하고 있습니다.
    ERR_SKILL_NOTE_07,             //20레벨이 되어야 구입할 수 있습니다.
    ERR_DIF_SERVER_GROUP_00,             //다른 서버의 유저와는 개인거래를 할 수 없습니다.
    ERR_DIF_SERVER_GROUP_01,             //다른 서버의 유저의 개인상점은 이용 할 수 없습니다.
    ERR_DIF_SERVER_GROUP_02,             //다른 서버의 유저는 길드로 초대 할 수 없습니다.
    ERR_DIF_SERVER_GROUP_03,             //다른 서버의 유저는 제자로 등록 할 수 없습니다.
    ERR_DIF_SERVER_GROUP_04,             //다른 서버의 유저는 친구로 등록 할 수 없습니다.
    ERR_DIF_SERVER_GROUP_05,             //헤니르의 시공 도전 모드는 다른 서버 유저와 함께 플레이 할 수 없습니다.
    ERR_ACCOUNT_BLOCK_00,             //해킹 의심 유저 접속 제한 조치.
    ERR_CLASS_CHANGE,             //[홍콩] 해당 직업으로는 전직을 할 수 없습니다.
    ERR_ITEM_15,             //버리려는 아이템 갯수 입력이 잘 못 되었습니다.
    ERR_PET_00,             //펫 생성을 실패 하였습니다.
    ERR_PET_01,             //이미 사용중인 펫 이름 입니다.
    ERR_PET_02,             //펫 이름은 최대 한글 6자(영문 12자)까지 가능합니다.
    ERR_PET_03,             //이미 펫 생성이 진행 중 입니다.
    ERR_PET_04,             //펫 소환을 실패 하였습니다.
    ERR_PET_05,             //여기서는 펫을 소환 할 수 없습니다.
    ERR_PET_06,             //소환된 펫이 없습니다.
    ERR_PET_07,             //이미 소환 되어 있는 펫 입니다.
    ERR_PET_08,             //펫 소환 해제를 실패 하였습니다.
    ERR_PET_09,             //펫 명령을 실패 하였습니다.
    ERR_PET_10,             //포만도가 ‘가득참’ 상태입니다. 더 이상 먹이를 먹을 수 없습니다.
    ERR_PET_11,             //펫 먹이 주기가 실패하였습니다.
    ERR_PET_12,             //펫이 '특별한'상태 입니다. 엘의 나무 열매/씨앗 만 먹습니다.
    ERR_PET_13,             //이미 저장 되어 있는 내용입니다.
    ERR_PET_14,             //더 이상 진화 할 수 없습니다.
    ERR_PET_15,             //친밀도가 100%가 되었을 때만 진화가 가능합니다.
    ERR_PET_16,             //장비아이템 또는 전용먹이만 섭취합니다.
    ERR_PET_17,             //장비의 레벨이 너무 낮습니다.
    ERR_GAMEFORGE_00,             //패스워드가 틀렸습니다.
    ERR_GAMEFORGE_01,             //계정이 존재하지 않습니다.
    ERR_GAMEFORGE_02,             //계정 승인이 되지 않았습니다. (User not validated)
    ERR_PET_18,             //펫에게 줄 수 있는 먹이 아이템이 아닙니다.
    ERR_PARTY_42,             //해당 유저가 다른 용무 중 입니다.
    ERR_GIANT_VERIFY_01,             //[CN] 매트릭스 카드가 바인딩되어 있습니다.
    ERR_GIANT_VERIFY_02,             //[CN] OPT번호가 틀렸습니다. 다시 입력해 주십시요.
    ERR_GIANT_VERIFY_03,             //[CN] 보안카드 번호를 잘못 입력 하셨습니다. 다시 입력해 주십시요.
    ERR_GIANT_STATE_01,             //[CN] 계정 정보가 수정 과정에 있습니다. 의문 사항이 있으시면 서비스 센터로 연락 바랍니다.
    ERR_GIANT_STATE_02,             //[CN] 자이언트 패스워드 보안이 바인딩 해제 상태에 있습니다. 의문사항이 있으시면 서비스 센터로 연락 바랍니다.
    STR_GM_NICKNAME_1,             //[TW]ServiceCode 가 잘못되었습니다.
    STR_GM_NICKNAME_2,             //GM리엘
    STR_DELETED_NICKNAME,             //[발신자 정보가 없습니다]
    ERR_BUY_CASH_ITEM_45,             //지금은 청약철회 기능을 이용 하실 수 없습니다.
    ERR_BUY_CASH_ITEM_46,             //청약철회 가능 개수보다 요청 갯수가 커서 청약철회를 실패하였습니다.
    ERR_BUY_CASH_ITEM_47,             //구매한지 7일이 초과된 상품으로 청약철회가 불가능 합니다.
    ERR_BUY_CASH_ITEM_48,             //패키지 중 일부 상품을 수령하여 청약철회가 불가능 합니다.
    ERR_BUY_CASH_ITEM_49,             //상품 가격이 0원으로 청약철회가 불가능한 상품 입니다.
    ERR_BUY_CASH_ITEM_50,             //중복된 RequestID입니다.
    ERR_BUY_CASH_ITEM_51,             //존재하지 않는 상품 구매 정보입니다.
    ERR_BUY_CASH_ITEM_52,             //존재하지 않는 상품 정보 입니다.
    ERR_BUY_CASH_ITEM_53,             //청약철회가 불가능한 상품 입니다.
    ERR_BUY_CASH_ITEM_54,             //선물 받은 상품이어서 청약철회가 불가능 합니다.
    ERR_ITEM_16,             //기간제 아이템은 버릴 수 없습니다.
    ERR_ITEM_17,             //되팔기 불능 아이템은 버릴 수 없습니다.
    ERR_BUY_CASH_ITEM_55,             //1 EL coins 이벤트 구매 제한을 초과 하여 더 이상 구매 할 수 없습니다.
    ERR_RANDOM_ITEM_08,             //레벨이 부족하여 아이템을 사용 할 수 없습니다.
    ERR_ENCHANT_ITEM_15,             //강화 레벨 11부터는 강화시 플루오르 스톤을 사용할 수 없습니다.
    ERR_QUEST_22,             //이미 보상을 받아서 퀘스트 수락을 할 수 없습니다.
    ERR_QUEST_23,             //수락 보상을 받을 인벤토리 공간이 부족하여 퀘스트를 수락할 수 없습니다.
    ERR_SOCKET_ITEM_10,             //마법석 사용을 실패하였습니다.
    ERR_BLOCK_TRADE_00,             //해당 기능은 현재 사용할 수 없습니다.\n 불편을 드려 죄송합니다.
    ERR_IP_BLOCK_00,             //접속이 제한된 IP입니다.
    ERR_CHAT_BLOCK_00,             //채팅 기능이 제한 되었습니다.
    ERR_BLOCK_TRADE_01,             //거래 기능이 제한 되었습니다.
    NOT_LEAVE_ROOM_REASON_22,             //' 아이템이 없어 게임을 시작 할 수 없습니다.
    ERR_KNP_03,             //다른 응용프로그램과의 충돌이 있습니다.
    ERR_GIANT_BILLING_01,             //[CN] 해당 유저가 존재하지 않습니다.
    ERR_GIANT_BILLING_02,             //[CN] 잔액이 부족합니다.
    ERR_GIANT_BILLING_03,             //[CN] 존재하지 않는 아이템 카드입니다.
    ERR_GIANT_BILLING_04,             //[CN] 동일한 쿠폰은 중복사용 할 수 없습니다.
    ERR_GIANT_BILLING_05,             //[CN] 이미 사용한 아이템 카드입니다.
    ERR_GIANT_BILLING_06,             //[CN] 잘못된 전용 카드 ID입니다.
    ERR_GIANT_BILLING_07,             //[CN] 잘못된 전용 카드 패스워드입니다.
    ERR_GIANT_BILLING_08,             //[CN] DB 에러
    ERR_BLOCK_TRADE_02,             //거래 제한 상태라서 편지 보내기 기능을 사용 하실 수 없습니다.
    ERR_BLOCK_TRADE_03,             //거래 제한 상태라서 개인 상점 개설을 할 수 없습니다.
    ERR_BLOCK_TRADE_04,             //거래 제한 상태라서 개인 상점을 볼 수 없습니다.
    ERR_BLOCK_TRADE_05,             //거래 제한 상태라서 물품 검색을 할 수 없습니다.
    ERR_BLOCK_TRADE_06,             //거래 제한 상태라서 거래 광장에 입장 할 수 없습니다.
    ERR_LIMITED_CASHITEM,             //캐시 인벤토리에 아이템이 존재합니다.(HK 이벤트에 사용)
    ERR_WORLD_MISSION_01,             //파티인원이 2인 이상이어야 합니다.
    ERR_WORLD_MISSION_02,             //던전이 닫혀 입장 할 수 없습니다.
    ERR_DIF_SERVER_GROUP_06,             //다른 서버 유저와 월드 미션 던전을 플레이 할 수 없습니다.
    ERR_EXIST_LETTER_MONITORING,             //우편 감시 로그에 중복된 값이 있습니다.
    ERR_EXIST_TRADE_MONITORING,             //거래 감시 로그에 중복된 값이 있습니다.
    ERR_INSERT_FAILD_LETTER_MONITORING,             //우편 감시 로그 추가 실패!
    ERR_INSERT_FAILD_TRADE_MONITORING,             //거래 감시로그 추가 실패!
    ERR_PERSONAL_SHOP_33,             //아직 판매중인 물품이 있어 대리상인을 종료할 수 없습니다!
    ERR_PERSONAL_SHOP_34,             //대리상인이 개설되어 있지 않습니다.
    ERR_PERSONAL_SHOP_35,             //판매 중지를 할 수 없습니다.
    ERR_PERSONAL_SHOP_36,             //판매 중지된 개인상점입니다. 물건을 구매할 수 없습니다.
    ERR_PERSONAL_SHOP_37,             //대리 판매인이 물품을 판매 하고 있어 상점을 개설 할 수 없습니다.
    ERR_WARNING_BLOCK_TRADE,             //(TW)비정상적인 방법으로 게임을 플레이 하고 있습니다. 계속 하시면 거래 정지 됩니다.
    ERR_PERSONAL_SHOP_38,             //대리상인을 종료할 수 없습니다.
    ERR_PAYLETTER_BILLING_01,             //Unregisted User.
    ERR_PAYLETTER_BILLING_02,             //It is already canceled.
    ERR_PAYLETTER_BILLING_03,             //Invalid coupon number.
    ERR_PAYLETTER_BILLING_04,             //This coupon can not be canceled.
    ERR_PAYLETTER_BILLING_05,             //The used user information and cancel the requested user information does not match.
    ERR_PAYLETTER_BILLING_06,             //The issued cash by coupons  already had used . so can not be canceled.
    ERR_PAYLETTER_BILLING_07,             //requested price should be equal to billing items price.
    ERR_PAYLETTER_BILLING_08,             //The balance short.
    ERR_PAYLETTER_BILLING_09,             //Billing account that is unavailable.
    ERR_PAYLETTER_BILLING_10,             //You can not register any more today.
    ERR_PAYLETTER_BILLING_11,             //This coupon can not verify the information.
    ERR_PAYLETTER_BILLING_12,             //Coupon is already used.
    ERR_PAYLETTER_BILLING_13,             //Coupon use is stopped.
    ERR_PAYLETTER_BILLING_14,             //Coupon is expired.
    ERR_PAYLETTER_BILLING_15,             //Coupon is not available in the game.
    ERR_PAYLETTER_BILLING_16,             //Issued to certain customers who can use coupons, you do not have permission.
    ERR_PAYLETTER_BILLING_17,             //Buying is a restricted user.
    ERR_PAYLETTER_BILLING_18,             //Your use is limited to the payment service.
    ERR_PAYLETTER_BILLING_19,             //Your use is limited to the purchase service.
    ERR_PAYLETTER_BILLING_20,             //User cannot be verified.
    ERR_PAYLETTER_BILLING_21,             //Registration has exceeded the number of coupons available.
    ERR_K3RCOMBO_AUTH_01,             //Unable to login due to IP restriction.
    ERR_PAYLETTER_BILLING_22,             //The coupon code has already been redeemed.
    ERR_PAYLETTER_BILLING_23,             //You cannot purchase the item at the moment. Your account have reached the daily limit for purchasing the item.
    ERR_VERIFY_22,             //2회이상 비밀번호를 틀려 로그인할 수 없습니다.
    ERR_PERSONAL_SHOP_39,             //대리 판매인에게 물품을 맡기려면 대리판매 보증서가 있어야 합니다.
    ERR_SECOND_SECURITY_AUTH_FAILED,             //입력하신 보안패드 암호가 서로 같지 않습니다.
    ERR_SECOND_SECURITY_AUTH_FAILED_LIMIT,             //보안패드 암호가 10회 실패하였습니다.\n[확인]버튼을 누르면 접속이 종료됩니다.\n재활성화 및 해제는 웹사이트에서 개인 인증 후 가능합니다.
    ERR_SECOND_SECURITY_DEFECT_PW,             //보안패드 암호 생성에 실패하였습니다.
    ERR_SECOND_SECURITY_DIFFER_PW,             //보안패드 암호가 일치하지 않습니다.
    ERR_PERSONAL_SHOP_40,             //상점 이름이 너무 깁니다.
    ERR_PERSONAL_SHOP_41,             //대리상점 판매가 종료된 상태입니다.\n물품받기 후 새롭게 상점 개설이 가능합니다.
    ERR_PERSONAL_SHOP_42,             //대리 판매인이 물품을 판매 중입니다.\n물품이나 판매수익을 받기 위해서는\n대리 판매인 상점을 종료 해야 합니다.
    ERR_PERSONAL_SHOP_43,             //대리 상인 보증서 DB쿼리 실패
    ERR_PERSONAL_SHOP_44,             //대리 상인을 생성을 실패하였습니다.
    ERR_PERSONAL_SHOP_45,             //대리 상인 물품 등록을 실패 하였습니다.
    ERR_PERSONAL_SHOP_46,             //대리 상점 개설자만 이용할 수 있습니다.
    ERR_PERSONAL_SHOP_47,             //대리 상점 물품 받기가 실패하였습니다.
    ERR_PERSONAL_SHOP_48,             //현재 구매가 이루어지고 있는 물품이어서 물품 받기가 실패하였습니다.
    ERR_PERSONAL_SHOP_49,             //이미 물품 받기가 진행중인 상태입니다.
    ERR_PERSONAL_SHOP_50,             //보유 가능한 ED량을 초과하여 물품받기가 실패하였습니다.
    ERR_PERSONAL_SHOP_51,             //인벤토리 공간이 부족하여 물품을 받을 수 없습니다.
    ERR_PERSONAL_SHOP_52,             //보관 중인 물품이 없습니다.
    ERR_PERSONAL_SHOP_53,             //동일한 물품에 대해서는 동시에 가져올 수 없습니다.
    ERR_MIN_LEVEL_JOIN_PARTY_FAILE,             //레벨 제한 조건을 만족하지 않습니다.\n파티 요청을 할 수 없습니다.
    ERR_PERSONAL_SHOP_54,             //아직 대리상인 기간이 남아서 상품을 구매할 수 없습니다.
    ERR_PERSONAL_SHOP_55,             //찾아가지 않은 물품이 있어 개인상점을 개설 할 수 없습니다.\n물품 받기를 확인 하세요!
    NOT_LEAVE_ROOM_REASON_26,             //대리 판매인의 판매 물품이 모두 판매되어 상점을 종료합니다.
    ERR_QUEST_24,             //이미 수락하여 보상을 받은 퀘스트 입니다. 퀘스트 수락을 할 수 없습니다.
    ERR_QUEST_25,             //인벤토리 슬롯이 부족하여 퀘스트 수락을 할 수 없습니다.
    ERR_PARTY_43,             //파티 최소 레벨 입장 제한을 변경하지 못했습니다.
    ERR_PERSONAL_SHOP_56,             //대리상점의 모든 물품이 판매될 경우 소지 한도 금액을 초과하게 되기 때문에 상점을 개설할 수 없습니다.
    ERR_ENCHANT_ITEM_16,             //(TW/HK)강화 보조 아이템 사용 불가
    ERR_ENCHANT_ITEM_17,             //(TW/HK)강화 보조 아이템이 없습니다.
    ERR_ENCHANT_ITEM_18,             //(TW/HK)파괴 방지 아이템 사용 불가
    ERR_ENCHANT_ITEM_19,             //(TW/HK)파괴 방지 아이템이 없습니다.
    ERR_CHANGE_DUNGEON_MAP_FAILE,             //레벨 제한 조건을 만족하지 않습니다.\n다른 던전을 선택하시거나 레벨제한을 해제하여야 합니다.
    ERR_CHANGE_PARTY_MIN_LEVEL_CHECK_FAILE,             //레벨 제한 조건을 만족하지 않습니다.\n레벨 제한을 활성화 할 수 없습니다.
    ERR_PARTY_INVITE_FAILE,             //레벨 제한 조건을 만족하지 않습니다.\n파티 초대를 할 수 없습니다.
    ERR_CREATE_PARTY_FAILE,             //레벨 조건을 만족하지 않습니다.\n다른 던전을 선택하시거나 레벨제한을 해제하여야 합니다.
    ERR_SECOND_SECURITY_DEFECT_PW_1,             //반복되는 숫자는 암호로 사용하실 수 없습니다.\n(0000, 1111, 999999 등)
    ERR_SECOND_SECURITY_DEFECT_PW_2,             //연속되는 숫자는 암호로 사용하실 수 없습니다.\n(1234, 9876, 123456 등)
    ERR_SECOND_SECURITY_DELETE_FAILE,             //2차 보안패드 삭제가 실패하였습니다.
    ERR_SECOND_SECURITY_NO_USE,             //2차 보안패드를 사용중이 아닙니다.
    ERR_SECOND_SECURITY_DEFECT_PW_3,             //이전 비밀번호와 동일한 비밀번호로\n변경 할 수 없습니다.
    ERR_BUY_ED_ITEM_06,             //상점에서 팔고있지 않는 아이템을 구매하려고 하였습니다.
    NOT_LEAVE_MATCH_REASON_00,             //대전 게임 시작으로 인한 매치 종료.
    NOT_LEAVE_MATCH_REASON_01,             //대전 매칭 대상자 중 누군가가 참여하지 않았습니다.
    NOT_LEAVE_MATCH_REASON_02,             //대전 매칭이 취소되었습니다.
    NOT_LEAVE_MATCH_REASON_03,             //파티원이 대전에 참여하지 않아서 대전 매칭이 취소되었습니다.
    NOT_LEAVE_MATCH_WAIT_REASON_00,             //매치가 성공하여 대기자 리스트에서 빠짐.
    NOT_LEAVE_MATCH_WAIT_REASON_01,             //유저가 매치 신청 취소를 하여 대기자 리스트에서 빠짐.
    NOT_LEAVE_MATCH_WAIT_REASON_02,             //파티원의 파티 탈퇴로 인해 매치 신청이 취소되었습니다.
    ERR_MATCH_MAKING_00,             //이미 매치 중인 상태입니다.
    ERR_MATCH_MAKING_01,             //대전 인원 정보가 이상합니다.
    ERR_MATCH_MAKING_02,             //대전 타입 정보가 이상합니다.
    ERR_MATCH_MAKING_03,             //공식 대전은 10레벨부터 가능합니다.
    ERR_MATCH_MAKING_04,             //대전 파티는 10레벨부터 이용 가능 합니다.
    ERR_MATCH_MAKING_05,             //이미 변경된 파티 타입 입니다.
    ERR_MATCH_MAKING_06,             //던전파티 인원이 4명일때는 대전파티로 변경이 불가능 합니다.
    ERR_MATCH_MAKING_07,             //파티 타입 변경 실패.
    ERR_MATCH_MAKING_08,             //파티원중에 10레벨이 안되는 멤버가 있어 대전파티로 변경이 불가능합니다.
    ERR_MATCH_MAKING_09,             //파티원중에 10레벨이 안되는 멤버가 있어 공식대전을 이용할 수 없습니다.
    ERR_MATCH_MAKING_10,             //10레벨 이상의 캐릭터만 대전파티에 초대 할 수 있습니다.
    ERR_MATCH_MAKING_11,             //10레벨 이상의 캐릭터만 대전 파티의 파티장으로 임명될 수 있습니다.
    ERR_EXCHANGE_CASH,             //[CN]전환이 정상적으로 이루어지지 않았습니다. 다시 시도하여 주시기 바랍니다.
    ERR_SORT_CATEGORY,             //[EU]연속으로 정렬할 수 없습니다.\n잠시 후 다시 시도해주세요.
    ERR_MATCH_MAKING_12,             //대전 매칭을 신청한 상태가 아닙니다.
    ERR_MATCH_MAKING_13,             //이미 대전방에 입장한 상태입니다.
    ERR_MATCH_MAKING_14,             //대전방이 아닙니다.
    ERR_MATCH_MAKING_15,             //대전 매칭 요청이 실패하였습니다.
    ERR_MATCH_MAKING_16,             //대전 매칭 신청한 유저는 파티에 초대 할 수 없습니다.
    ERR_MATCH_MAKING_17,             //대전 매칭중인 유저는 파티에 초대 할 수 없습니다.
    ERR_BUY_ED_ITEM_07,             //대전 랭크가 낮아 해당 아이템을 구매할 수 없습니다.
    ERR_MATCH_MAKING_18,             //대전 매칭 신청을 한 상태에서는 다른 파티에 가입 신청을 할 수 없습니다.
    ERR_MATCH_MAKING_19,             //대전 매칭중인 상태에서는 다른 파티에 가입 신청을 할 수 없습니다.
    ERR_MATCH_MAKING_20,             //대전 매칭 상태에서는 채널이동 기능을 사용하실 수 없습니다.
    ERR_CHECK_MACHINE_ID_00,             //머신 ID 인증 실패.
    ERR_USER_REGISTRATION_10,             //머신ID로 인한 이중접속 감지.
    ERR_QUEST_26,             //오늘 수락 할 수 있는 랜덤 퀘스트가 아닙니다.
    ERR_K3RCOMBO_AUTH_02,             //약관에 동의하지 않았습니다.
    ERR_ODBC_02,             //SP 출력 값에 문제가 있습니다.
    ERR_ODBC_03,             //SP 입력 값에 문제가 있습니다.
    ERR_ODBC_04,             //목적 DB 이름이 잘못 되었습니다.
    ERR_ODBC_05,             //데이터 검증 실패
    ERR_CONTENT_00,             //죄송합니다. 캐쉬샵 점검으로 인해 이용하실 수 없습니다.
    ERR_SHUT_DOWN_00,             //00시부터 06시까지 게임 접속이 제한됩니다.
    ERR_GM_CHAR_DENY_01,             //정보를 가져오지 못했습니다.
    ERR_TRADE_BLOCK_UNIT_00,             //새로 생성한 캐릭터의 경우 5일 이내 거래를 할 수 없습니다.
    ERR_TRADE_BLOCK_UNIT_01,             //새로 생성한 캐릭터의 경우 5일 이내 편지를 전송할 수 없습니다.
    ERR_GIANT_BILLING_09,             //[CN]사용실패!
    NOT_LEAVE_ROOM_REASON_27,             //배틀필드 입장을 위한 방 이탈 입니다.
    ERR_SHARING_BANK_01,             //Lv.15가 되어야 구입하실 수 있습니다.
    ERR_SERVERSN_01,             //ServerSN과 MachineID가 매칭되지 않는다.
    ERR_SERVERSN_02,             //MachineID와 ServerSN이 매칭되지 않는다.
    ERR_SERVERSN_03,             //DB에 존재 하지 않는 ServerSN이 있다.
    ERR_SERVERSN_04,             //DB에 존재 하지 않는 MachineID가 있다.
    ERR_SERVERSN_05,             //클라가 준 SN은 없는데 DB에는 MachineID에 해당하는 SN 존재.
    ERR_SERVERSN_06,             //제재된 SN입니다.
    ERR_SERVERSN_07,             //접속 제한된 ServerSN 입니다.
    ERR_VERIFY_23,             //이 계정은 테스트서버의 계정이 아닙니다.
    NOT_LEAVE_PARTY_REASON_06,             //파티 병합을 위한 자동 파티 이탈입니다.
    ERR_BUY_CASH_ITEM_56,             //이미 스킬 슬롯 확장을 사용 중입니다. 스킬 슬롯 확장(기간제) 상품을 가져올 수 없습니다.
    ERR_BUY_CASH_ITEM_57,             //이미 스킬 슬롯 확장을 기간 무제한으로 사용 중입니다. 상품을 가져올 수 없습니다.
    ERR_GIANT_VERIFY_04,             //[CN] 귀하의 계정이 정지되었습니다. 고객 센터에 문의하여 주십시요.
    ERR_GIANT_VERIFY_05,             //[CN] 비밀번호를 잘못 입력 하셨습니다. 다시 입력해 주십시요.
    ERR_GIANT_VERIFY_06,             //[CN] 해당 계정은 존재하지 않습니다.
    ERR_GIANT_VERIFY_07,             //[CN] 불명확인 시스템 에러
    ERR_RANDOM_ITEM_09,             //이미 동일한 아이템을 사용 중 입니다.
    ERR_BUY_CASH_ITEM_58,             //레벨이 부족하여 구매할 수 없습니다.
    ERR_BUY_CASH_ITEM_59,             //레벨이 부족하여 상품을 가져올 수 없습니다.
    NOT_CLOSE_PARTY_REASON_00,             //파티 생성 실패.
    NOT_CLOSE_PARTY_REASON_01,             //파티 인원 수 부족.
    NOT_CLOSE_PARTY_REASON_02,             //파티 초대에 대한 초대 대상자의 응답 지연.
    ERR_BUY_CASH_ITEM_60,             //[JP] 판매하지 않는 상품입니다.
    ERR_BUY_CASH_ITEM_61,             //[JP] 한게임 빌링 오류로 구매할수 없습니다.
    ERR_SHARE_BANK_01,             //공유은행 아이템은 우편으로 보낼 수 없습니다.
    ERR_SHARE_BANK_02,             //공유은행 아이템은 거래 할 수 없습니다.
    ERR_BUY_CASH_ITEM_62,             //[US] 레벨 20이 되어야 구입하실 수 있습니다.
    ERR_ITEM_EXCHANGE_ONLY_GUILD_MEMBER_00,             //[EU] 길드에 소속된 캐릭터만 교환 할 수 있습니다.
    ERR_BUY_CASH_ITEM_63,             //[US] 레벨 30이 되어야 구입하실 수 있습니다.
    ERR_PARTY_44,             //[US] PVP파티에는 풀패치일때만 참가요청을 할 수 있습니다.
    ERR_CHECK_DLL_01,             //블랙리스트에 등록된 DLL 이 존재합니다.
    ERR_QUIZ_00,             //[CN] 잠시 후 다시 시도해 주시거나 캐릭터를 재접속 해주시기 바랍니다.
    ERR_QUIZ_01,             //[CN] 오늘 퀴즈 이용 횟수를 초과 하셨습니다.
    ERR_QUIZ_02,             //[CN] 알 수 없는 에러 입니다. (퀴즈)
    ERR_BUY_CASH_ITEM_64,             //[JP] 거래제한기간중에는구매할수 없습니다.
    ERR_BUY_CASH_ITEM_65,             //[JP] 거래제한기간중에는 사용할 수 없습니다.
    ERR_BUY_CASH_ITEM_66,             //더 이상 퀵 슬롯을 확장 할 수 없습니다.
    ERR_DELETE_UNIT_01,             //[CN] 이미 삭제되었거나 삭제 대기 상태의 캐릭입니다.
    ERR_DELETE_UNIT_02,             //[CN] 캐릭터 삭제 가능한 기간이 아닙니다.
    ERR_DELETE_UNIT_03,             //[CN] 캐릭터 최종 삭제 가능 기간이 아닙니다.
    ERR_DELETE_UNIT_04,             //[CN] 최종 삭제 가능한 캐릭터가 아닙니다.
    ERR_RESTORE_UNIT_01,             //[CN] 삭제 복구 대상 캐릭터가 아닙니다.
    ERR_RESTORE_UNIT_02,             //[CN] 캐릭터 복구 가능 기간이 아닙니다.
    ERR_SORT_CATEGORY_01,             //잠시후에 정렬을 시도해주세요.
    ERR_DELETE_UNIT_00,             //해당 캐릭터를 찾을 수 없습니다.
    ERR_DELETE_UNIT_05,             //캐릭터 삭제를 실패 하였습니다.
    ERR_PET_19,             //펫 이름 변경에 실패 하였습니다.
    ERR_PET_20,             //이미 펫 이름 변경이 진행 중입니다.
    ERR_SHUT_DOWN_01,             //게임 이용이 차단 됩니다.
    ERR_GUILD_46,             //길드마스터가 아닙니다.
    ERR_GUILD_47,             //아이템 정보가 이상합니다.
    ERR_GUILD_48,             //길드 이름 변경 실패!
    ERR_GUILD_49,             //이미 진행 중인 작업입니다.
    ERR_GUILD_50,             //존재하지 않는 아이템을 삭제 시도하였습니다.
    ERR_FISH_01,             //[TW] 낚시대를 장착하지 않았거나, 미끼가 없습니다.
    ERR_FISH_02,             //[TW] 이미 사용중인 낚시터 입니다.
    ERR_FISH_03,             //[TW] 낚시터에 문제가 있습니다. 다른 곳을 이용해 주세요.
    ERR_FISH_04,             //[TW] 낚시 보상에 문제가 발생했습니다.
    ERR_ITEM_18,             //아이템 삭제를 실패 하였습니다.
    ERR_BUY_CASH_ITEM_67,             //길드 이름 변경권은 길드 마스터만 사용 가능합니다.
    ERR_PET_21,             //펫이 있을 때만 사용이 가능합니다. 펫이 없을 경우 일주일 이내에 청약 철회를 하셔야 합니다.
    ERR_GUILD_51,             //처리 시간이 지연되어 작업이 무효화 되었습니다. 재시도 해주시기 바랍니다.
    ERR_GUILD_52,             //유저가 길드 이름 변경을 취소하였습니다.
    ERR_BATTLEFIELD_00,             //해당 지역으로 이동할 수 있는 상태가 아닙니다.
    ERR_BATTLEFIELD_01,             //이미 해당 지역에 입장한 상태입니다.
    ERR_BATTLEFIELD_02,             //이미 해당 지역은 가득차 있어 입장할 수 없습니다.
    ERR_BATTLEFIELD_03,             //해당 지역에는 이미 다른 파티들로 인해 입장할 공간이 없습니다.
    ERR_BATTLEFIELD_04,             //해당 지역에 입장을 실패하였습니다.
    ERR_BATTLEFIELD_05,             //입장하려는 지역 정보가 잘못되었습니다.
    ERR_BATTLEFIELD_06,             //해당 지역에 입장하려는 중 오류가 발생하였습니다.
    ERR_BATTLEFIELD_07,             //해당 지역에서 유저 정보 찾기가 실패하였습니다.
    ERR_AUTO_PARTY_00,             //자동 파티로 던전 게임 시작을 실패하였습니다.
    ERR_BATTLEFIELD_08,             //던전 게임 시작을 실패하였습니다.
    ERR_AUTO_PARTY_01,             //자동 파티 신청을 할 수 없는 상태입니다.
    ERR_AUTO_PARTY_02,             //재집결을 위한 휴식 버프로 인해 자동 파티 신청을 할 수 없습니다. 버프가 풀릴때까지 기다려주세요.
    ERR_AUTO_PARTY_03,             //이미 자동 파티 신청이 된 상태입니다.
    ERR_AUTO_PARTY_04,             //잘못된 정보로 인해 자동 파티 신청이 실패하였습니다.
    ERR_AUTO_PARTY_05,             //자동 파티 대기자로 등록이 실패하였습니다.
    ERR_AUTO_PARTY_06,             //자동 파티 신청 상태가 아닙니다.
    ERR_BATTLEFIELD_09,             //파티원 수가 1명뿐이어서 게임을 시작할 수 없습니다.
    NOT_PARTY_GAME_START_FAILED_00,             //파티구성원 중 취소한 유저가 있습니다.
    NOT_PARTY_GAME_START_FAILED_01,             //파티 게임 시작에 대한 응답시간이 지나 파티 게임을 시작하지 않습니다.
    ERR_BATTLEFIELD_10,             //이미 파티에 소속된 상태입니다.
    ERR_BATTLEFIELD_11,             //초대 대상자가 이미 다른 파티 가입을 기다리는 중입니다.
    ERR_BATTLEFIELD_12,             //파티에 소속된 상태가 아닙니다.
    ERR_USE_ITEM_IN_INVENTORY_06,             //영약 또는 비약은 중첩하여 사용할 수 없습니다.
    ERR_SN_OVERLAP_01,             //ServerSN이 중복 접속 중이다.
    ERR_SN_OVERLAP_02,             //ServerSN 존재하지 않는데 삭제하려한다.
    ERR_INVENTORY_LOCK_00,             //현재 사용할 수 없는 기능입니다.
    ERR_NX_AUTH_00,             //넥슨 통합 맵버쉽 계정 인증 상향 조정 필요.
    ERR_USE_ITEM_IN_INVENTORY_07,             //육체의 한계 버프가 켜져 있습니다. 비약을 사용할 수 없습니다.
    ERR_DUNGEON_GAME_START_00,             //레벨 제한 조건을 만족하지 않습니다. 던전 게임을 시작할 수 없습니다.
    ERR_RECOMMEND_USER_02,             //[US] 추천받을 대상이 아닙니다.
    ERR_RECOMMEND_USER_03,             //[US] 추천인이 이미 3인을 추천하였습니다.
    ERR_RECOMMEND_USER_04,             //[US] 추천 가능한 유저가 아닙니다.
    ERR_RECOMMEND_USER_05,             //[US] 맞지 않는 아이템을 사용하였습니다.
    ERR_ITEM_21,             //[US] 캐릭터 슬롯을 확장할 수 없습니다. 슬롯 확장은 9개까지 가능합니다.
    NOT_LEAVE_AUTO_PARTY_REASON_00,             //던전 게임 시작으로 인한 자동 파티 종료.
    NOT_LEAVE_AUTO_PARTY_REASON_01,             //자동 파티 대상자 중 누군가가 게임 시작에 동의하지 않았습니다.
    NOT_LEAVE_AUTO_PARTY_REASON_02,             //자동 파티 취소 요청에 의해 성공적으로 종료되었습니다.
    NOT_LEAVE_AUTO_PARTY_REASON_03,             //파티원이 자동파티 게임시작에 동의하지 않아 자동파티가 취소되었습니다.
    NOT_LEAVE_AUTO_PARTY_WAIT_REASON_00,             //자동파티가 성공하여 대기자 리스트에서 빠짐.
    NOT_LEAVE_AUTO_PARTY_WAIT_REASON_01,             //유저가 자동파티 신청 취소를 하여 대기자 리스트에서 빠짐.
    NOT_LEAVE_AUTO_PARTY_WAIT_REASON_02,             //파티원의 파티 탈퇴로 인해 자동파티 신청이 취소되었습니다.
    ERR_DUNGEON_GAME_START_01,             //아이템 레벨 제한 조건을 만족하지 않습니다. 던전 게임을 시작할 수 없습니다.
    ERR_KEYBOARD_MAPPING_01,             //키보드 맵핑 정보를 저장하지 못하였습니다.
    ERR_KEYBOARD_MAPPING_02,             //모든 키보드 맵핑 정보를 저장하는데 실패하였습니다.
    ERR_KEYBOARD_MAPPING_03,             //키보드 맵핑 정보를 읽어오지 못하였습니다.
    ERR_KEYBOARD_MAPPING_04,             //모든 키보드 맵핑 정보를 읽어오는데 실패하였습니다.
    ERR_PARTY_45,             //파티 던전 게임 시작을 위한 응답이 지연되었습니다.
    ERR_RECOMMEND_USER_06,             //[US] 추천인 테이블에서 캐릭터 삭제를 실패하였습니다.
    ERR_K3RCOMBO_AUTH_03,             //[US] 보안패드 리셋용 질문 및 답변을 입력하지 않았습니다.
    ERR_SEARCH_UNIT_05,             //같은 파티원이 아닙니다.
    ERR_CHAT_OPTION_01,             //채팅 옵션 정보를 저장하는데 실패하였습니다.
    ERR_CHAT_OPTION_02,             //채팅 옵션 정보를 읽어오는데 실패하였습니다.
    ERR_CHAT_OPTION_03,             //일부 채팅 옵션 정보를 읽어오는데 실패하였습니다.
    ERR_KEYBOARD_MAPPING_05,             //테스트
    ERR_PAYLETTER_BILLING_24,             //[US] 한달에 $1,000 까지만 선물이 가능합니다.
    ERR_SHUT_DOWN_02,             //나이정보를 확인 중 오류가 발생하였습니다. 잠시 후 다시 로그인하여 주십시오.
    ERR_SHUT_DOWN_03,             //실명인증을 받지 않은 회원이거나 넥슨닷컴 회원이 아닙니다.
    ERR_SHUT_DOWN_04,             //셧다운제에 의하여 게임이용이 차단 됩니다.
    ERR_SHUT_DOWN_05,             //선택적 셧다운제의 의해 게임이용이 차단됩니다.
    ERR_VERIFY_24,             //통합 맴버십 ATL 2.0 유저가 아니므로 게임이용이 차단 됩니다.
    ERR_RANDOM_ITEM_10,             //오픈 가능 시간이 되지 않았습니다.
    ERR_RANDOM_ITEM_11,             //오픈 가능 시간이 지나 오픈 할 수 없습니다.
    ERR_AS_BILLING_00,             //ServiceID가 잘못 되었습니다.
    ERR_AS_BILLING_01,             //캐시 잔액 정보를 찾을 수 없습니다.
    ERR_GASH_18,             //[TW]ServiceCode 가 올바르지 않습니다.
    ERR_GASH_19,             //[TW]정의되지 않은 애러 발생했습니다.
    ERR_GASH_20,             //[TW]시간형식이 잘못되었습니다.
    ERR_GASH_21,             //[TW]Type정보가 잘못되었습니다.
    ERR_GASH_22,             //[TW]이전 상품 구매가 진행 중입니다.
    ERR_QUEST_27,             //레벨이 높아 퀘스트를 수락 받지 못합니다.
    ERR_AS_BILLING_02,             //파라매터 갯수 입력이 잘못되었습니다.
    ERR_SYNTHESIS_01,             //[JP] 합성제가 없습니다.
    ERR_SYNTHESIS_02,             //[JP] 없는 아바타를 합성하려고 했습니다.
    ERR_PAYLETTER_BILLING_25,             //[US]월 선물 가능 횟수를 초과하였습니다.
    ERR_PARTY_46,             //[CN]1인 플레이 던전 입니다.
    ERR_PARTY_47,             //[CN]던전 오픈 시간이 아닙니다.
    ERR_SELECT_UNIT_07,             //정상적인 캐릭터 선택이 아닙니다.
    ERR_POST_LETTER_20,             //캐릭터 자신에게 일반우편을 보낼려고 했습니다.
    ERR_PET_25,             //펫 정보가 이상합니다.
    ERR_PET_22,             //펫이 소환된 상태에서만 사용 가능합니다.
    ERR_PET_24,             //성체 상태의 펫만 사용 가능합니다.
    ERR_PET_23,             //유체 상태의 펫만 사용 가능합니다.
    ERR_ROOM_48,             //태그 횟수 세팅이 이상합니다.
    ERR_ROOM_49,             //팀원이 최소 2명 이상이어야 시작할 수 있습니다.
    ERR_PVP_01,             //대전 아이템은 이용할 수 없는 기능입니다.
    ERR_PVP_02,             //대전 아이템 사용 횟수가 남지 않았습니다.
    ERR_PVP_03,             //대전 아이템 사용 횟수가 남지 않았습니다.
    ERR_PVP_04,             //대전 아이템 사용 횟수가 남지 않았습니다.
    NOT_LEAVE_ROOM_REASON_28,             //던전 게임 입장을 위한 배틀필드 이탈입니다.
    NOT_LEAVE_ROOM_REASON_32,             //대전 게임 입장을 위한 이탈입니다.
    NOT_LEAVE_ROOM_REASON_29,             //채널 이동에 의한 이탈입니다.
    NOT_LEAVE_ROOM_REASON_31,             //같은 파티원 찾아가기에 의한 이탈입니다.
    NOT_LEAVE_ROOM_REASON_30,             //이동 아이템 사용에 의한 이탈입니다.
    NOT_LEAVE_ROOM_REASON_33,             //비정상종료로 인한 이탈.
    ERR_PARTY_48,             //던전 게임중에는 파티원을 초대 할 수 없습니다.
    ERR_PARTY_54,             //이미 다른 파티에 소속되어 있어 초대 할 수 없습니다.
    ERR_PARTY_51,             //대상이 대전 게임중이라 초대할 수 없습니다.
    ERR_PARTY_50,             //대상이 던전 게임중이라 초대할 수 없습니다.
    ERR_PARTY_53,             //동일한 서버에서 해당 유저를 찾을 수 없습니다.
    ERR_PARTY_52,             //더 이상 파티원을 초대 할 수 없습니다.
    ERR_PARTY_49,             //대전 게임중에는 파티원을 초대 할 수 없습니다.
    ERR_BATTLEFIELD_13,             //필드에 입장할 수 있는 레벨이 부족합니다.
    ERR_BATTLEFIELD_14,             //필드에 입장할 수 있는 조건의 던전을 클리어 하지 않았습니다.
    ERR_QUEST_28,             //퀘스트는 최대 30개까지만 수행이 가능합니다.
    ERR_USE_ITEM_IN_INVENTORY_08,             //보유한 ED가 부족합니다.
    ERR_PARTY_55,             //자동 파티 매칭중인 유저는 파티 초대를 할 수 없습니다.
    ERR_PARTY_59,             //자동 파티 매칭중일때는 파티 초대를 할 수 없습니다.
    ERR_PARTY_57,             //대전 로비에서는 파티 초대를 할 수 없습니다.
    ERR_PARTY_56,             //훈련중에는 파티원을 초대할 수 없습니다.
    ERR_MATCH_MAKING_22,             //대전 매칭 중에는 파티 초대를 할 수 없습니다.
    ERR_PARTY_58,             //자동 파티 신청을 등록한 상태에서는 파티 초대를 할 수 없습니다.
    ERR_MATCH_MAKING_21,             //대전 매칭 신청을 등록한 상태에서는 파티 초대를 할 수 없습니다.
    ERR_BATTLEFIELD_15,             //현재 필드가 파티가 소속된 필드 입니다.
    ERR_PARTY_60,             //이미 다른 파티 초대 대기자 상태여서 파티 초대를 할 수 없습니다.
    ERR_PAYLETTER_BILLING_26,             //이 이벤트 쿠폰은 계정당 한 번만 받을 수 있습니다.
    ERR_CJ_01,             //[ID] ID 또는 비밀번호가 잘못되었습니다.
    ERR_HERO_PVP_USER_LIST_02,             //등록되어있지 않은 닉네임입니다.
    ERR_HERO_PVP_USER_LIST_01,             //서버 그룹 아이디가 잘못되었습니다.
    ERR_SHARE_BANK_03,             //[TW] 공유 은행 처리중인 아이템 입니다. 은행을 닫고 다시 시도해 주세요.
    ERR_ROOM_50,             //온라인 토너먼트 참가 신청권이 없는 유저는 대회 채널을 이용하실 수 없습니다.
    ERR_RANDOM_ITEM_12,             //큐브를 개봉 하기 위해서는 아이템과 ed 가 필요합니다.
    ERR_RANDOM_ITEM_13,             //ED가 부족해서 큐브를 개봉 할 수 없습니다.
    ERR_PARTY_61,             //현재 인원으로 시작합니다.
    ERR_GUILD_CN01,             //길드 생성은 하루에 한 번 가능합니다.
    ERR_CJ_02,             //[ID] ID 는 최소 4자에서 최대 20자 까지 입력 가능 합니다.
    ERR_CJ_03,             //[ID] PW 는 최소 6자에서 최대 15자 까지 입력 가능합니다.
    ERR_ITEM_22,             //이벤트 기간이 끝났습니다.
    ERR_NX_SHOP_10,             //아라 캐릭터로는 가져올 수 없는 아이템입니다.
    ERR_PAYLETTER_BILLING_27,             //금일 선물하기 제한을 초과하였습니다.
    ERR_ITEM_EXCHANGE_05,             //아쉽게도 교환 수향이 모두 소진 되었습니다. 1월 17일 점검 이후 교환 수량이 추가 됩니다.
    ERR_CJ_04,             //[ID] 인증실패 : 서버와의 연결을 확인해 주십시오.
    ERR_PET_26,             //존재하지 않는 펫입니다.
    ERR_PET_28,             //이미 사용 중인 기능입니다.
    ERR_PET_27,             //유체 이상일 경우에만 사용 가능합니다.
    ERR_SKILL_28,             //게임 대기 중인 상태에서는 스킬 슬롯을 변경할 수 없습니다.
    ERR_BATTLEFIELD_16,             //현재 방에 입장한 상태가 아니라서 필드 몬스터 정보 불러오기를 실패하였습니다.
    ERR_BATTLEFIELD_17,             //필드방 상태가 아니어서 필드 몬스터 정보 불러오기를 실패하였습니다.
    ERR_BUY_CASH_ITEM_68,             //캐릭터 슬롯 확장 상품을 구매할 수 없습니다. 슬롯 확장은 30개까지 가능합니다.
    NOT_LEAVE_ROOM_REASON_34,             //던전 강퇴 투표에 의한 이탈입니다.
    ERR_BAD_ATTITUDE_00,             //투표자가 정상적인 유저가 아닙니다.
    ERR_BAD_ATTITUDE_01,             //투표자가 정상적인 유저가 아닙니다.
    ERR_PAYLETTER_BILLING_28,             //빌링 서버가 초기화 되지 않았습니다.
    ERR_PAYLETTER_BILLING_30,             //상품 구매중 문제가 발생하였습니다.
    ERR_PAYLETTER_BILLING_29,             //구매 처리 중입니다. 잠시 후에 다시 시도해 주세요.
    ERR_BINGO_01,             //아직 처리 중인 작업이 있습니다. 잠시 후에 다시 시도 해주세요.
    ERR_BINGO_02,             //아직 빙고판이 완성되지 않았습니다.
    ERR_BINGO_03,             //일시적인 오류입니다. 잠시 후에 다시 시도 해주세요.
    ERR_GUILD_FIND_BOARD_01,             //초대 메시지 등록 비용이 부족하므로 등록할 수 없습니다.
    ERR_GUILD_FIND_BOARD_07,             //길드 초대 메시지 등록을 실패하였습니다.
    ERR_GUILD_FIND_BOARD_04,             //길드구함 광고 등록을 실패하였습니다.
    ERR_GUILD_FIND_BOARD_03,             //길드 초대 요청이 실패하였습니다.
    ERR_GUILD_FIND_BOARD_06,             //이미 등록한 길드구함 광고가 있습니다.
    ERR_GUILD_FIND_BOARD_05,             //이미 등록한 길드 초대 메시지가 있습니다.
    ERR_GUILD_FIND_BOARD_08,             //길드구함 광고 등록 비용이 부족하므로 등록할 수 없습니다.
    ERR_GUILD_FIND_BOARD_02,             //해당 길드가 최대 인원에 도달하여 가입하실 수 없습니다.
    ERR_GUILD_FIND_BOARD_10,             //길드 초대 메시지가 존재하지 않습니다.
    ERR_GUILD_FIND_BOARD_09,             //길드구함 광고가 존재하지 않습니다.
    ERR_GUILD_FIND_BOARD_11,             //존재하지 않는 길드입니다.
    ERR_GUILD_FIND_BOARD_12,             //초대 유저 목록을 볼 수 있는 권한이 없습니다.
    ERR_DUNGEON_ENTER_LIMIT_00,             //[US] 던전 입장 회수 제한을 초과하였습니다.
    ERR_LOCALRANKING_04,             //로컬 랭킹 유저 정보 초기화 오류
    ERR_LOCALRANKING_01,             //로컬 랭킹 유저 정보가 초기화 되어있지 않습니다.
    ERR_LOCALRANKING_03,             //프로필 정보는 20자까지만 입력 가능합니다.
    ERR_LOCALRANKING_06,             //로컬 랭킹 게시판 조회 오류
    ERR_LOCALRANKING_05,             //로컬 랭킹 유저 정보 쓰기 오류
    ERR_LOCALRANKING_02,             //다음 정보 수정은 익일 06시 이후에 가능합니다.
    ERR_PARTY_62,             //[TW]2인 플레이 던전입니다.
    ERR_RECOMMEND_USER_07,             //더 이상 추천 할 수 없는 유저입니다.
    ERR_LOCALRANKING_07,             //넥슨 계정 인증 실패입니다.
    ERR_RECOMMEND_USER_09,             //투니랜드 계정이거나, 계정 인증 이후 추천 가능 합니다.
    ERR_RECOMMEND_USER_08,             //동일 명의의 계정이므로 추천 할 수 없습니다.
    ERR_RECOMMEND_USER_10,             //추천을 실패 하였습니다.
    ERR_LOCALRANKING_08,             //PASSWORD 길이가 잘못되었습니다.
    ERR_LOCALRANKING_09,             //프로필 정보에 사용할 수 없는 단어가 들어있습니다.
    ERR_HERO_PVP_USER_LIST_06,             //영웅 대전 후보 리스트에 이미 존재하는 유닛입니다.
    ERR_HERO_PVP_USER_LIST_03,             //닉네임 길이가 잘못되었습니다.
    ERR_HERO_PVP_USER_LIST_05,             //영웅 대전 후보 리스트에 존재하지 않는 유닛입니다.
    ERR_HERO_PVP_USER_LIST_04,             //--/;/따옴표/쉼표/공백 등은 사용할 수 없습니다.
    ERR_EVENT_NOTE_02,             //필드 100% 즐기기 필수 가이드북를\n 보유하고 있지 않습니다.
    ERR_EVENT_NOTE_01,             //챕터 등록을 실패 하였습니다.
    ERR_EVENT_NOTE_00,             //이미 가이드 북에 기록되어 있습니다.
    ERR_LOCALRANKING_10,             //해당 유닛은 존재하지 않습니다.
    ERR_UDP_01,             //UNKNOWN
    ERR_RELATIONSHIP_06,             //벌써 임자가 있습니다.
    ERR_RELATIONSHIP_03,             //양다리는 안됩니다!
    ERR_RELATIONSHIP_00,             //마을, 필드에서만 커플 신청을 할 수 있습니다.
    ERR_RELATIONSHIP_08,             //접속중인 유저가 아닙니다.
    ERR_RELATIONSHIP_02,             //인벤토리에 커플링이 존재하지 않습니다.
    ERR_RELATIONSHIP_05,             //동성 캐릭터간의 커플은 한국에서는 안됩니다.
    ERR_RELATIONSHIP_04,             //해당 서버군에 존재하지 않는 캐릭터 명입니다.
    ERR_RELATIONSHIP_07,             //커플 신청 받는 유저의 정보가 이상합니다.
    ERR_RELATIONSHIP_01,             //정상적인 캐릭터 명이 아닙니다.
    ERR_LOCALRANKING_12,             //알 수 없는 에러입니다.
    ERR_LOCALRANKING_11,             //존재하지 않는 유저입니다.
    ERR_RELATIONSHIP_10,             //상대방이 실수로 커플링을 떨어트렸어요! 얼른 찾아오라고 말해주세요!
    ERR_RELATIONSHIP_09,             //상대방이 수락했지만, 내 인벤토리에 커플링이 없어요! 인벤토리를 확인해 주세요!
    ERR_RELATIONSHIP_11,             //인연 시스템 사용 아이템 삭제 실패
    ERR_RELATIONSHIP_12,             //요청한 연인 정보의 캐릭터 정보가 이상합니다.
    ERR_RELATIONSHIP_13,             //당신은 솔로입니다. 연인이 없어 드릴 정보가 없습니다.
    ERR_RELATIONSHIP_17,             //선택한 옵션값이 이상합니다.
    ERR_RELATIONSHIP_14,             //인벤토리에 결혼반지가 존재하지 않습니다.
    ERR_RELATIONSHIP_16,             //선택한 옵션에 필요한 캐시 아이템이 인벤토리에 존재하지 않습니다.
    ERR_RELATIONSHIP_18,             //결혼을 하기 위해서는 커플이 되고 72시간이 지나야 합니다.
    ERR_RELATIONSHIP_15,             //결혼을 하려면 커플 상태여야 합니다.
    ERR_FREE_FIRST_CLASS_CHANGE_EVENT_01,             //무료 1차 전직 이벤트를 진행할 수 있는 상태가 아닙니다.
    ERR_RELATIONSHIP_19,             //인벤토리에 결혼에 필요한 아이템이 존재하지 않습니다.
    ERR_RELATIONSHIP_20,             //결혼하기 아이템 사용 실패 하였습니다.
    ERR_RELATIONSHIP_21,             //결혼식에 초대하려는 인원 수보다 인벤토리에 있는 초대권 수가 부족합니다.
    ERR_FREE_FIRST_CLASS_CHANGE_EVENT_02,             //이벤트 기간이 종료되어 전직이 불가능합니다.
    ERR_RIDING_PET_03,             //더 이상 탈 것을 생성할 수 없습니다.
    ERR_RIDING_PET_02,             //탈 것 생성 아이템을 사용할 수 없습니다.
    ERR_RIDING_PET_04,             //탈 것 정보를 가져오지 못했습니다.
    ERR_RIDING_PET_01,             //탈 것을 생성할 수 있는 아이템이 아닙니다.
    ERR_RIDING_PET_05,             //탈 것 생성에 실패 하였습니다.
    ERR_RIDING_PET_07,             //이미 다른 탈 것이 소환되어 있습니다.
    ERR_RIDING_PET_06,             //존재하지 않는 탈 것입니다.
    ERR_RIDING_PET_09,             //해당 탈 것은 소환되어 있지 않습니다.
    ERR_RIDING_PET_08,             //소환되어 있는 탈 것이 없습니다.
    ERR_RIDING_PET_11,             //탈 것 놓아주기에 실패하였습니다.
    ERR_RIDING_PET_10,             //소환되어 있는 탈 것은 놓아줄 수 없습니다.
    ERR_RIDING_PET_12,             //탈 것을 소환할 수 없는 지역입니다.
    ERR_RIDING_PET_13,             //보유 중인 탈 것이 없습니다.
    ERR_RELATIONSHIP_22,             //존재하지 않는 아이템에 대한 정보를 요청하였습니다.
    ERR_RELATIONSHIP_23,             //웨딩 관련 아이템이 아닙니다.
    ERR_RELATIONSHIP_24,             //웨딩 관련 아이템의 정보가 없습니다.
    ERR_RELATIONSHIP_25,             //예약된 결혼식장의 정보가 없습니다.
    ERR_RELATIONSHIP_26,             //결혼식을 예약한 유저의 닉네임을 찾을 수 없습니다.
    ERR_RELATIONSHIP_27,             //사용가능한 커플, 결혼 상태가 아닙니다.
    ERR_RELATIONSHIP_28,             //던전에서는 소환하기를 사용 할 수 없습니다.
    ERR_GLOBAL_BILLING_01,             //[INT] 지원하지 않는 캐시 타입 입니다.
    ERR_RELATIONSHIP_29,             //소환하기를 사용 할 준비가 되지 않았습니다.
    ERR_RELATIONSHIP_30,             //동일 채널에서만 소환하기가 가능합니다.
    NOT_LEAVE_ROOM_REASON_35,             //연인 소환을 위한 필드 이탈
    ERR_RELATIONSHIP_31,             //아이템 정보가 존재하지 않습니다.
    ERR_RELATIONSHIP_33,             //결혼식장에 입장 가능한 위치가 아닙니다.
    ERR_RELATIONSHIP_32,             //결혼식장에 입장 가능한 아이템이 아닙니다.
    NOT_LEAVE_ROOM_REASON_36,             //결혼식장 입장을 위한 필드 이탈
    ERR_RELATIONSHIP_34,             //결혼식이 완료 되었거나 존재하지 않는 결혼식입니다.
    ERR_RELATIONSHIP_36,             //커플 상태가 아닙니다.
    ERR_RELATIONSHIP_37,             //결혼식장에 입장이 실패하였습니다.
    ERR_RELATIONSHIP_38,             //현재 필드에 소환이 불가능 합니다.
    ERR_RELATIONSHIP_39,             //이별이 가능한 위치가 아닙니다.
    ERR_RELATIONSHIP_40,             //위자료를 지불 할 수 없습니다.
    ERR_RELATIONSHIP_41,             //신랑이나 신부가 아닙니다.
    ERR_RELATIONSHIP_42,             //신랑 신부가 모두 방에 존재해야 합니다.
    ERR_RELATIONSHIP_SYSTEM_LAUNCHING_EVENT_01,             //사랑의 리퀘스트를 가지고 오세요~뽀~
    ERR_RELATIONSHIP_SYSTEM_LAUNCHING_EVENT_02,             //러브 뽀루가 우편으로 지급되었습니다.
    ERR_REQUEST_OF_LOVE_01,             //러브 뽀루가 우편으로 지급되었습니다.
    ERR_REQUEST_OF_LOVE_02,             //사랑의 리퀘스트를 가지고 오세요~뽀~
    ERR_REQUEST_OF_LOVE_03,             //뽀루의 러브 레터를 발송하려면 1만 ED가 필요합니다.
    ERR_REQUEST_OF_LOVE_04,             //뽀루의 러브 레터를 발송하지 못했습니다.
    ERR_RELATIONSHIP_43,             //인연 상태가 아닙니다.
    ERR_RELATIONSHIP_44,             //애칭 변경권의 정보가 이상합니다.
    ERR_DELETE_UNIT_06,             //인연 상태에서는 삭제 할 수 없습니다.
    ERR_COBO_EXPRESS_01,             //[ES_INT] VIP 기간 갱신 중 문제가 발생했습니다.
    ERR_SYNTHESIS_03,             //[JP] 선택 할 수 없는 옵션입니다.
    ERR_SYNTHESIS_04,             //[JP] 합성 부위가 다릅니다.
    ERR_RELATIONSHIP_45,             //결혼 상태가 아닙니다.
    ERR_RELATIONSHIP_46,             //연인이 필드 입장에 실패 하였습니다.
    ERR_EVALUATE_ITEM_05,             //축복받은 시공간의 주문서를 사용할 아이템 레벨이 맞지 않습니다.
    ERR_EVALUATE_ITEM_03,             //이미 감정이 된 아이템 입니다.
    ERR_EVALUATE_ITEM_00,             //연인이 필드 입장에 실패 하였습니다.
    ERR_EVALUATE_ITEM_02,             //아이템 감정을 위한 수수료가 부족합니다.
    ERR_EVALUATE_ITEM_04,             //아이템 감정을 실패 하였습니다.
    ERR_EVALUATE_ITEM_06,             //축복받은 시공간의 주문서 수량이 부족합니다.
    ERR_EVALUATE_ITEM_01,             //해당 아이템은 감정할 수 없습니다.
    ERR_RED_VS_BLUE_EVENT_00,             //[ES_INT]이미 같은 계정의 다른 캐릭터로 신청하셨습니다.
    ERR_RED_VS_BLUE_EVENT_01,             //[ES_INT]이미 해당 캐릭터로 신청하셨습니다.
    ERR_EVALUATE_ITEM_07,             //변경 대상 아이템이 아닙니다.
    ERR_EVALUATE_ITEM_08,             //아이템 변경에 필요한 수수료가 부족합니다.
    ERR_DANO_EVENT_01,             //[ES_INT]금일 이벤트에 응모할 응모권이 없습니다.
    ERR_DANO_EVENT_02,             //[ES_INT]금일 이벤트 응모에 실패하였습니다. 다시 시도해 주세요.
    ERR_DANO_EVENT_03,             //[ES_INT]이벤트 기간이 끝났습니다.
    ERR_SKILL_29,             //동일 등급의 스킬을 동시에 습득하려고 합니다.
    ERR_EXCHANGE_LIMIT_02,             //교환 가능한 수량이 모두 소진되었습니다.
    ERR_EXCHANGE_LIMIT_01,             //아이템 교환에 실패하였습니다.
    ERR_EXCHANGE_LIMIT_03,             //오늘의 붉은 기사단 초대 확정권은\n모두 소진되었습니다.\n일일 수량은 06시에 갱신됩니다.\n내일 다시 도전해주세요!
    ERR_TRADE_BLOCK_UNIT_02,             //새로 생성한 캐릭터의 경우 5일 이내 거래를 할 수 없습니다.
    ERR_ITEM_EXCHANGE_06,             //기간제 아이템은 재료나 교환 아이템으로\n사용할 수 없습니다.
    ERR_MANUFACTURE_12,             //기간제 아이템은 재료나 교환 아이템으로\n사용할 수 없습니다.
    ERR_ATTACH_ITEM_04,             //요구 조건을 만족하지 않습니다. 확인해주세요.
    ERR_LEVELUP_01,             //[BR] 레벨업 인증 에러
    ERR_RELATIONSHIP_47,             //엘소드와 엘리시스는 남매이므로 커플 요청을 할 수 없습니다.
    ERR_NOT_USE_01,             //현재 레벨에서는 사용할 수 없습니다.
    ERR_CREATE_UNIT_11,             //선택한 유닛 클래스 정보가 이상합니다.
    ERR_JUMPING_04,             //해당되는 점핑 이벤트가 없습니다.
    ERR_JUMPING_01,             //점핑 이벤트 대상자가 아닙니다.
    ERR_JUMPING_07,             //점핑 하려는 대상 직업이 이상합니다.
    ERR_JUMPING_06,             //점핑은 마을이나 필드에서만 가능합니다.
    ERR_JUMPING_03,             //점핑 이벤트 정보가 초기화 되지 않았습니다.
    ERR_JUMPING_08,             //점핑 캐릭터 오류입니다.
    ERR_JUMPING_02,             //기본 직업 대상자만 점핑할 수 있습니다.
    ERR_JUMPING_05,             //점핑 이벤트 대상자가 아닙니다.
    ERR_EXTRACT_06,             //아이템을 생성하지 못했습니다.
    ERR_EXTRACT_03,             //기간제 아이템은 추출 할 수 없습니다.
    ERR_EXTRACT_00,             //추출 가능한 아이템이 아닙니다.
    ERR_EXTRACT_02,             //아이템 수량이 이상합니다.
    ERR_EXTRACT_05,             //인벤토리 공간이 부족합니다.
    ERR_EXTRACT_04,             //아이템 추출에 실패하였습니다.
    ERR_EXTRACT_01,             //추출 아이템 정보가 이상합니다.
    ERR_FINALITY_SKILL_03,             //아이템 사용에 실패하였습니다.
    ERR_FINALITY_SKILL_00,             //궁극기 사용 아이템이 아닙니다.
    ERR_FINALITY_SKILL_02,             //아이템 수량이 이상합니다.
    ERR_FINALITY_SKILL_01,             //아이템 정보가 이상합니다.
    ERR_ODBC_06,             //해당 데이터 없음
    ERR_BLOCK_TRADE_07,             //거래 정지 상태의 계정은 개인 거래를 할 수 없습니다.
    ERR_USE_ITEM_IN_QUICKSLOT_00,             //배틀필드에서는 NPC카드를 사용할 수 없습니다
    ERR_EVENT_PET_02,             //이 열매는 '베르드의 마수'에게만 먹일 수 있습니다.
    ERR_EVENT_PET_01,             //'정화의 열매'만 먹일 수 있습니다.
    ERR_NX_COUPON_11,             //취소된 쿠폰입니다.
    ERR_NX_COUPON_08,             //PC방에서만 사용할 수 있는 쿠폰입니다.
    ERR_NX_COUPON_07,             //쿠폰 오류입니다.
    ERR_NX_COUPON_13,             //사용 제한 수량을 초과하였습니다.
    ERR_NX_COUPON_10,             //쿠폰 등록에 실패하였습니다.
    ERR_NX_COUPON_09,             //쿠폰 정보 읽기에 실패하였습니다.
    ERR_NX_COUPON_12,             //쿠폰핀 규칙이 맞지 않습니다.
    ERR_NX_COUPON_06,             //잘못된 쿠폰 박스 타입입니다.
    ERR_NX_COUPON_14,             //해당 쿠폰의 할인 적용 가능 아이템 목록 읽기에 실패하였습니다.
    ERR_CLIENT_QUIT_03,             //CheckKom.xml 파싱 오류로 인한 종료입니다.
    ERR_GARENA_BILLING_01,             //
    ERR_ROOM_51,             //스테이지 정보가 잘못되었습니다.
    ERR_RELATIONSHIP_EVENT_00,             //인벤토리에 가상 결혼 신청서가 존재하지 않습니다.
    ERR_RELATIONSHIP_EVENT_03,             //인벤토리에 가상 결혼 계약서가 존재하지 않습니다.
    ERR_RELATIONSHIP_EVENT_02,             //가상 결혼 상대방이 존재하지 않습니다.
    ERR_RELATIONSHIP_EVENT_04,             //가상 결혼 계약서 삭제 실패
    ERR_RELATIONSHIP_EVENT_01,             //가상 결혼 신청서 삭제 실패
    ERR_HW_PET_03,             //조건이 맞지 않습니다. 펫이 소환되어 있는지 확인 바랍니다.
    ERR_HW_PET_02,             //조건이 맞지 않습니다. 사용 가능한 펫 인지 확인 바랍니다.
    ERR_HW_PET_04,             //축하합니다! 할로윈 호박 요정의 묘약을 성공적으로 사용 하셨습니다.
    ERR_HW_PET_01,             //조건이 맞지 않습니다. 펫 친밀도가 100% 인지 확인 바랍니다.
    NOT_CREATE_CHARACTER_BY_COUNT,             //캐릭터 생성 횟수제한에 의해 캐릭터를 생성할 수 없습니다.
    ERR_RELATIONSHIP_EVENT_05,             //상대방이 수락했지만, 내 인벤토리에 가상 결혼 신청서가 없어요! 인벤토리를 확인해 주세요!
    ERR_RELATIONSHIP_EVENT_06,             //상대방이 실수로 가상 결혼 신청서를 잃어버렸어요! 얼른 찾아오라고 말해주세요!
    ERR_RELATIONSHIP_EVENT_07,             //가상 부부 상대방이 있어야 시작할 수 있습니다.
    ERR_MATCH_MAKING_23,             //던전 게임 신청 중에는 사용할 수 없는 기능입니다.
    ERR_AUTO_PARTY_07,             //공식 대전 신청 중에는 사용할 수 없는 기능입니다.
    ERR_AUTO_PARTY_08,             //룸 리스트 조회 중에는 사용할 수 없는 기능입니다.
    ERR_DUNGEON_01,             //올바르지 않은 SubStageID 입니다.
    ERR_ROOM_52,             //플레이 가능 횟수를 초과하였습니다.
    ERR_EVENT_PET_03,             //브라질 쁘띠 뽀루에게만 사용 할 수 있습니다.
    ERR_ROOM_53,             //공식 대전에는 난입할 수 없습니다.
    ERR_ROOM_54,             //잘못된 스테이지 정보 요청입니다.
    ERR_NX_COUPON_17,             //적용 가능 하한 금액 미만입니다.
    ERR_NX_COUPON_16,             //적용 가능 상한 금액 초과입니다.
    ERR_NX_COUPON_19,             //이미 등록된 쿠폰입니다.
    ERR_NX_COUPON_18,             //할인 대상 아이템이 아닙니다.
    ERR_NX_COUPON_15,             //PC방이 아닙니다.
    ERR_PERSONAL_SHOP_57,             //현재 대리 판매 보증서(VIP)를 이용 중입니다
    ERR_PERSONAL_SHOP_58,             //대리상인에 등록된 아이템이 있어서 다른 종류의 보증서를 등록할 수 없습니다.
    NOT_REQUEST_TRADE_REPLY_05,             //해당 유저는 거래가 제한된 상태입니다.
    ERR_EXPAND_INVENTORY_ED_01,             //ED 가 부족합니다
    ERR_EXPAND_INVENTORY_ED_02,             //더 이상 슬롯을 확장할 수 없습니다.
    ERR_EXPAND_INVENTORY_ED_03,             //확장에 필요한 금액이 잘못되었습니다.
    ERR_BATTLEFIELD_19,             //해당 필드는 열려있지 않습니다.
    ERR_BATTLEFIELD_18,             //현재 필드에서는 입장할 수 없습니다.
    ERR_BATTLEFIELD_20,             //재도전을 위한 휴식 버프로 인해 시간의 포탈에 입장 할 수 없습니다. 다음 포탈 생성시까지 기다려 주세요.
    ERR_CLIENT_QUIT_04,             //Kom 파일의 변조로 인한 종료입니다.
    ERR_NX_COUPON_20,             //쿠폰 총 사용 횟수를 초과하여 사용하실 수 없습니다.
    ERR_ROOM_55,             //보스 필드 입장에 실패하였습니다. 다시 시도 해주세요.
    ERR_ADMIN_COMMAND_10,             //사용할 수 없는 권한입니다.
    ERR_FIELD_BOSS_02,             //보스 필드 쿨타임 상태입니다. 닫은 후에 다시 시도해주세요.
    ERR_FIELD_BOSS_01,             //해당 필드에서는 보스 필드 게이트가 생성되지 않습니다.
    ERR_FIELD_BOSS_04,             //사용 권한이 없습니다.
    ERR_FIELD_BOSS_03,             //보스 필드가 아닙니다.
    ERR_FIELD_BOSS_05,             //쿨 타임 상태입니다.
    ERR_FIELD_BOSS_06,             //보스 필드정보가 존재하지 않습니다.
    ERR_DELETE_UNIT_07,             //사전 생성한 캐릭터는 삭제할 수 없습니다
    ERR_FIELD_BOSS_07,             //보스 필드의 제한 시간이 종료되었습니다.
    ERR_FIELD_BOSS_13,             //무기와 방어구 아이템에만 사용 할 수 있습니다.
    ERR_FIELD_BOSS_19,             //소켓 슬롯 추가에 실패하였습니다.
    ERR_FIELD_BOSS_16,             //인벤토리의 재료 아이템만 사용할 수 있습니다.
    ERR_FIELD_BOSS_10,             //파괴된 아이템에는 사용할 수 없습니다.
    ERR_FIELD_BOSS_18,             //방어구 소켓 슬롯을 추가하기 위한 재료 아이템을 가지고 있지 않습니다.
    ERR_FIELD_BOSS_15,             //소켓 슬롯 추가에 필요한 재료 아이템이 존재하지 않습니다.
    ERR_FIELD_BOSS_09,             //인벤토리의 아이템에만 사용할 수 있는 기능입니다.
    ERR_FIELD_BOSS_12,             //장착 불가 아이템에는 사용할 수 없습니다.
    ERR_FIELD_BOSS_11,             //PC방 프리미엄 아이템에는 사용할 수 없습니다.
    ERR_FIELD_BOSS_17,             //무기 소켓 슬롯을 추가하기 위한 재료 아이템을 가지고 있지 않습니다.
    ERR_FIELD_BOSS_14,             //더 이상 소켓 슬롯을 추가 할 수 없습니다.
    ERR_FIELD_BOSS_08,             //소켓 슬롯 추가에 필요한 대상 아이템이 존재하지 않습니다.
    ERR_HACKSHIELD_00,             //hsb 파일이 클라이언트와 맞지 않습니다.
    ERR_SKILL_PAGE_04,             //활성화 중인 스킬 페이지 번호가 이상 합니다.
    ERR_SKILL_PAGE_01,             //클라이언트에서 보내준 활성화된 스킬 페이지 번호가 서버의 정보와 다릅니다.
    ERR_SKILL_PAGE_03,             //사용하기로 선택한 스킬 페이지가 이상 합니다.
    ERR_SKILL_PAGE_05,             //추가된 페이지에 기본을 스킬 등록 하지 못 했습니다.
    ERR_SKILL_PAGE_02,             //더 이상 스킬 페이지를 확장 할 수 없습니다.
    ERR_SKILL_PAGE_06,             //스킬 페이지를 확장한 적이 없는데 페이지 변경을 시도함
    ERR_SKILL_PAGE_07,             //스킬 페이지 변경 업데이트 실패
    ERR_SKILL_PAGE_08,             //마을 및 휴식처에서만 구매 가능 합니다.
    ERR_SKILL_PAGE_09,             //1개권 만 구입 가능 합니다.
    ERR_CLASS_CHANGE_EVENT_01,             //더 이상 구입 할 수 없습니다.
    ERR_ITEM_INT_01,             //버프 효과가 지속되고 있는 동안 동일한 버프 효과의 아이템을 다시 사용할 수 없습니다.
    ERR_AUTO_PARTY_09,             //레벨 그룹이 다른 유저와 전장을 같이 플레이 할 수 없습니다.
    NOT_LEAVE_PARTY_REASON_07,             //불량 유저 검사 시스템에 의한 파티 이탈입니다.
    NOT_LEAVE_PARTY_REASON_08,             //파티 재결합에 의한 파티 이탈입니다.
    NOT_LEAVE_PARTY_REASON_09,             //유효하지 않은 파티원 검사에 의한 파티 이탈입니다.
    NOT_LEAVE_PARTY_REASON_10,             //어둠의 문 진입 전 이탈로 인한 파티 이탈입니다.
    ERR_ACCOUNT_BLOCK_03,             //당신의 계정은 차단되었습니다(LE3) 웹사이트를 방문하여 문의 하세요.
    ERR_ACCOUNT_BLOCK_02,             //로그인이 불가능합니다(LE2). 웹사이트를 방문하여 문의 하세요.
    ERR_ACCOUNT_BLOCK_04,             //당신의 계정은 차단되었습니다(LE4) 웹사이트를 방문하여 문의 하세요.
    ERR_ACCOUNT_BLOCK_01,             //로그인이 불가능합니다(LE1). 웹사이트를 방문하여 문의 하세요.

    ERR_SENTINEL
    ;

    val value: Int

    private object Counter {
        var value = 0
    }

    constructor() {
        Counter.value++
        value = Counter.value
//        println("[$value] $name")
    }

    constructor(value: Int) {
        this.value = value
        Counter.value = value
//        println("[$value] $name")
    }
}