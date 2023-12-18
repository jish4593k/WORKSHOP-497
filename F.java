public class ProgressBar {
    private int length;
    private double progress;

    public ProgressBar(int length) {
        this.length = length;
        this.progress = 0;
    }

    public void update(double progress) {
        this.progress = Math.max(0, Math.min(progress, 1));
        display();
    }

    private void display() {
        int bar = (int) Math.round(length * progress);
        String status = progress >= 1 ? "Done" : "Working...";
        String text = String.format("\r[%s] %.2f%% %s",
                "#".repeat(bar) + "-".repeat(length - bar), progress * 100, status);
        System.out.print(text);
        System.out.flush();
    }

    public static void main(String[] args) {
        ProgressBar progressBar = new ProgressBar(40);

        for (int i = 0; i <= 100; i++) {
            try {
                Thread.sleep(50);  
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            progressBar.update(i / 100.0);
        }
    }
}
