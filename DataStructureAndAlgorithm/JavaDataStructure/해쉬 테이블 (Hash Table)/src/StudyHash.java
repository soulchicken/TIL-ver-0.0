public class StudyHash {
    public static void main(String[] args) {
        MyHash hash = new MyHash(20);
        hash.saveData("SOUL","1234");
        hash.saveData("soul","5678");
        System.out.println(hash.getData("SOUL"));
        hash.saveData("Star","1111");
        System.out.println(hash.getData("SOUL")); // hash 함수가 잘 안되있으면 충돌이 일어나 이렇게 값이 변한다
    }
}