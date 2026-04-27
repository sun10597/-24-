package lion.jdbc.scheduler;

import lion.jdbc.scheduler.dto.ScheduleDTO;
import lion.jdbc.scheduler.service.ScheduleServiceImpl;
import lion.jdbc.scheduler.service.ScheduleService;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

public class Scheduler {
    private static final Scanner sc = new Scanner(System.in);
    private static final ScheduleService service = new ScheduleServiceImpl();

    public static void main(String[] args) throws SQLException {
        while (true){
            printMenu();
            System.out.print("선택: ");
            String choice = sc.nextLine();

            switch(choice){
                case "1":
                    createSchedule(sc);
                    break;
                case "2":
                    listSchedule(sc);
                    break;
                case "0":
                    System.out.println("프로그램 종료");
                    return;
                default:
                    System.out.println("잘못된 메뉴입니다.");
            }

        }
    }

    private static void printMenu(){
        System.out.println("\n===  일정 관리  ===");
        System.out.println("1. 일정 등록");
        System.out.println("2. 일정 목록");
        System.out.println("0. 종료");
    }

    private  static void createSchedule(Scanner sc) throws SQLException {
        System.out.println("\n--- [일정 등록] ---");
        ScheduleDTO dto = new ScheduleDTO();

        System.out.print("제목: ");
        dto.setTitle(sc.nextLine());
        System.out.print("내용: ");
        dto.setContent(sc.nextLine());

        try {
            System.out.print("시작날짜 (형식: 2026-04-23T15:00): ");
            dto.setStartAt(LocalDateTime.parse(sc.nextLine()));

            System.out.print("종료날짜 (형식: 2026-04-23T16:00): ");
            dto.setEndAt(LocalDateTime.parse(sc.nextLine()));
        } catch (java.time.format.DateTimeParseException e) {
            System.out.println("날짜 형식이 잘못되었습니다. (예: 2026-04-23T15:00)");
            return;
        }

        System.out.print("카테고리 ID (1.공부 2.알바 3.개인): ");
        dto.setCategoryId(Integer.parseInt(sc.nextLine()));

        service.insertSchedule(dto);
        System.out.println("일정이 등록되었습니다.");

    }

    private static void listSchedule(Scanner sc) throws SQLException {
        System.out.println("\n--- [일정 목록] ---");
        List<ScheduleDTO> list = service.findAll();

        if (list.isEmpty()) {
            System.out.println("등록된 일정이 없습니다.");
            return;
        }

        System.out.println("\t제목\t\t상태\t\t시작날짜");
        for (ScheduleDTO s : list) {
            System.out.printf("[%d] %s | %s | %s\n",
                    s.getScheduleId(), s.getTitle(), s.getStatus(), s.getStartAt());
        }

        System.out.print("\n상세보기 할 ID (0은 메인으로): ");
        int id = Integer.parseInt(sc.nextLine());
        if (id == 0) return;

        viewSchedule(id);
    }

    private static void viewSchedule(int id) throws SQLException {
        ScheduleDTO schedule = service.findById(id);
        if (schedule == null) {
            System.out.println("해당 일정을 찾을 수 없습니다.");
            return;
        }

        System.out.println("\n--- [" + id + "번 일정 정보] ---");
        System.out.println(schedule);

        System.out.println("\n1. 상태 변경 | 2. 일정 삭제 | 0. 목록으로");
        System.out.print("선택: ");
        String choice = sc.nextLine();

        switch(choice){
            case "1":
                service.updateScheduleStatus(id);
                System.out.println("완료 처리되었습니다.");
                break;
            case "2":
                service.deleteSchedule(id);
                System.out.println("삭제되었습니다.");
                break;

        }
    }

}
