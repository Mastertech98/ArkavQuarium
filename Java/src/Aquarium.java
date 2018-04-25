import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Aquarium extends JPanel {
  private final int sizeX;
  private final int sizeY;

  private int gameTime;

  private final LinkedList<Guppy> guppies = new LinkedList<>();
  private final LinkedList<Piranha> piranhas = new LinkedList<>();
  private final LinkedList<Snail> snails = new LinkedList<>();
  private final LinkedList<Food> foods = new LinkedList<>();
  private final LinkedList<Coin> coins = new LinkedList<>();

  private int money;
  private int egg;
  private int eggPrice;

  public Aquarium(int sizeX, int sizeY, int money, int eggPrice) {
    this.sizeX = sizeX;
    this.sizeY = sizeY;

    setGameTime(0);
    add(new Snail(this));
    setMoney(money);
    setEgg(0);
    setEggPrice(eggPrice);

    addMouseListener(new MouseListener() {
      @Override
      public void mouseClicked(MouseEvent e) {

      }

      @Override
      public void mousePressed(MouseEvent e) {
        boolean coinClick = false;
        for (ElementList<Coin> o = getCoins().getFirst();
             o != null && !coinClick; o = o.getNext()) {
          if (new Vector2(e.getX(), e.getY()).distance(o.getData().getPosition()) <= 16) {
            o.getData().take();
            coinClick = true;
          }
        }
        if (getMoney() > Food.price && !coinClick) {
          add(new Food(Aquarium.this, e.getX()));
          setMoney(getMoney() - Food.price);
        }
      }

      @Override
      public void mouseReleased(MouseEvent e) {

      }

      @Override
      public void mouseEntered(MouseEvent e) {

      }

      @Override
      public void mouseExited(MouseEvent e) {

      }
    });

    JButton buyGuppy = new JButton("Buy Guppy");
    buyGuppy.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (getMoney() >= Guppy.price) {
          add(new Guppy(Aquarium.this));
          setMoney(getMoney() - Guppy.price);
        }
      }
    });

    JButton buyPiranha = new JButton("Buy Piranha");
    buyPiranha.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (getMoney() >= Piranha.price) {
          add(new Piranha(Aquarium.this));
          setMoney(getMoney() - Piranha.price);
        }
      }
    });

    JButton buyEgg = new JButton("Buy Egg");
    buyEgg.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        if (getMoney() >= getEggPrice()) {
          setEgg(getEgg() + 1);
          setMoney(getMoney() - getEggPrice());
        }
      }
    });

    add(buyGuppy);
    add(buyPiranha);
    add(buyEgg);
  }

  public int getSizeX() {
    return sizeX;
  }

  public int getSizeY() {
    return sizeY;
  }

  public int getGameTime() {
    return gameTime;
  }

  public LinkedList<Guppy> getGuppies() {
    return guppies;
  }

  public LinkedList<Piranha> getPiranhas() {
    return piranhas;
  }

  public LinkedList<Snail> getSnails() {
    return snails;
  }

  public LinkedList<Food> getFoods() {
    return foods;
  }

  public LinkedList<Coin> getCoins() {
    return coins;
  }

  public int getMoney() {
    return money;
  }

  public int getEgg() {
    return egg;
  }

  public int getEggPrice() {
    return eggPrice;
  }

  public void setGameTime(int gameTime) {
    this.gameTime = gameTime;
  }

  public void setMoney(int money) {
    this.money = money;
  }

  public void setEgg(int egg) {
    this.egg = egg;
  }

  public void setEggPrice(int eggPrice) {
    this.eggPrice = eggPrice;
  }

  public void add(Guppy guppy) {
    guppies.add(guppy);
  }

  public void add(Piranha piranha) {
    piranhas.add(piranha);
  }

  public void add(Snail snail) {
    snails.add(snail);
  }

  public void add(Food food) {
    foods.add(food);
  }

  public void add(Coin coin) {
    coins.add(coin);
  }

  public void remove(Guppy guppy) {
    guppies.remove(guppy);
  }

  public void remove(Piranha piranha) {
    piranhas.remove(piranha);
  }

  public void remove(Snail snail) {
    snails.remove(snail);
  }

  public void remove(Food food) {
    foods.remove(food);
  }

  public void remove(Coin coin) {
    coins.remove(coin);
  }

  public void tick() {
    setGameTime(getGameTime() + 1);

    for (ElementList<Guppy> o = getGuppies().getFirst(), next; o != null; o = next) {
      next = o.getNext();
      o.getData().tick();
    }
    for (ElementList<Piranha> o = getPiranhas().getFirst(), next; o != null; o = next) {
      next = o.getNext();
      o.getData().tick();
    }
    for (ElementList<Snail> o = getSnails().getFirst(), next; o != null; o = next) {
      next = o.getNext();
      o.getData().tick();
    }
    for (ElementList<Food> o = getFoods().getFirst(), next; o != null; o = next) {
      next = o.getNext();
      o.getData().tick();
    }
    for (ElementList<Coin> o = getCoins().getFirst(), next; o != null; o = next) {
      next = o.getNext();
      o.getData().tick();
    }
  }

  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g.drawImage(ArkavQuarium.objectImage[20], 0, 0, sizeX, sizeY, null);

    int gameTime = getGameTime();

    for (ElementList<Guppy> e = getGuppies().getFirst(); e != null; e = e.getNext()) {
      Guppy guppy = e.getData();

      int idx = 0;
      idx += (guppy.getGrowthStage() - 1) * 4;
      idx += (guppy.getIsMovingRight() ? 1 : 0) * 2;
      idx += (gameTime >= guppy.getLastMealTime() + guppy.getFullTime() ? 1 : 0);

      Vector2 position = guppy.getPosition();

      g.drawImage(
          ArkavQuarium.objectImage[idx],
          (int) position.abscissa - 64, (int) position.ordinate - 64, null);
    }
    for (ElementList<Piranha> e = getPiranhas().getFirst(); e != null; e = e.getNext()) {
      Piranha piranha = e.getData();

      int idx = 12;
      idx += (piranha.getIsMovingRight() ? 1 : 0) * 2;
      idx += (gameTime >= piranha.getLastMealTime() + piranha.getFullTime() ? 1 : 0);

      Vector2 position = piranha.getPosition();

      g.drawImage(
          ArkavQuarium.objectImage[idx ],
          (int) position.abscissa - 64, (int) position.ordinate - 64, null);
    }
    for (ElementList<Snail> e = getSnails().getFirst(); e != null; e = e.getNext()) {
      Snail snail = e.getData();
      Vector2 position = snail.getPosition();
      int idx = snail.getIsMovingRight() ? 1 : 0;
      g.drawImage(
          ArkavQuarium.objectImage[idx + 16],
          (int) position.abscissa - 64, (int) position.ordinate - 64, null);
    }
    for (ElementList<Food> e = getFoods().getFirst(); e != null; e = e.getNext()) {
      Food food = e.getData();

      int idx = 0;

      Vector2 position = food.getPosition();

      g.drawImage(
          ArkavQuarium.objectImage[idx + 18],
          (int) position.abscissa - 16, (int) position.ordinate - 16, null);
    }
    for (ElementList<Coin> e = getCoins().getFirst(); e != null; e = e.getNext()) {
      Coin coin = e.getData();

      int idx = 0;

      Vector2 position = coin.getPosition();
      g.drawImage(
          ArkavQuarium.objectImage[idx + 19],
          (int) position.abscissa - 16, (int) position.ordinate - 16, null);
    }

    g.drawString("Money: " + String.valueOf(getMoney()), 8, 16);
    g.drawString("Egg: " + String.valueOf(getEgg()), 8, 32);

    if (ArkavQuarium.win == 1) {
      g.drawString("Win", 8, 48);
    } else if (ArkavQuarium.win == -1) {
      g.drawString("Lose", 8, 48);
    }

    repaint();
  }
}